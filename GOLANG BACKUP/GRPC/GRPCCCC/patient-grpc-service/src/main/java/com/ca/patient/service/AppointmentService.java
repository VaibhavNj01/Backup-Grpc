package com.ca.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ca.patient.Appointment;
import com.ca.patient.CreateAppointmentRequest;
import com.ca.patient.GetAppointmentByIdRequest;
import com.ca.patient.GetAppointmentByPatientIdRequest;
import com.ca.patient.ReactorAppointmentServiceGrpc;
import com.ca.patient.dao.AppointmentRepository;
import com.ca.patient.dao.PatientRepository;
import com.ca.patient.dao.PracticeRepository;
import com.ca.patient.exception.CustomException;
import com.ca.patient.exception.NotFoundException;
import com.ca.patient.mapper.AppointmentMapper;
import com.ca.patient.model.PatientInfo;
import com.ca.patient.model.PracticeInfo;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@GrpcService
@Slf4j
public class AppointmentService extends ReactorAppointmentServiceGrpc.AppointmentServiceImplBase {
	
	private final AppointmentRepository appointmentRepository;

	private final PatientRepository patientRepository;

	private final PracticeRepository practiceRepository;

	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository,
			PracticeRepository practiceRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
		this.practiceRepository = practiceRepository;
	}

	@Override
	public Mono<Appointment> getAppointmentById(GetAppointmentByIdRequest request) {
		try {
			Optional<com.ca.patient.model.Appointment> appointment = appointmentRepository
					.findById(request.getAppointmentId());
			if (appointment.isPresent()) {
				return Mono.just(AppointmentMapper.MAPPER.mapToAppointmentProtobuf(appointment.get()));
			} else {
				return Mono.error(new NotFoundException("Appointment not found"));
			}
		} catch (Exception e) {
			return Mono.error(e);
		}
	}

	@Override
	public Flux<Appointment> getAppointmentByPatientId(GetAppointmentByPatientIdRequest request) {
	    try {
	        List<com.ca.patient.model.Appointment> appointments = appointmentRepository
	                .findByPatientPatientId(request.getPatientId());
	        if (appointments.isEmpty()) {
	            return Flux.empty();
	        }
	        Flux<Appointment> appointmentsProto = Flux
	                .fromIterable(AppointmentMapper.MAPPER.mapToAppointmentProtobuf(appointments));
	        return appointmentsProto;
	    } catch (Exception e) {
	    	log.error("An error occurred while retrieving appointments by patientId", e);
	    	throw new CustomException("An error occurred while retrieving appointments by patientId", e);
	    }
	}

	@Override
	public Mono<Appointment> createAppointment(CreateAppointmentRequest request) {
		try {
			com.ca.patient.model.Appointment appointment = AppointmentMapper.MAPPER.mapToAppointmentModel(request);
	        PatientInfo patient = patientRepository.findByPatientId(request.getPatientId());
	        PracticeInfo practiceInfo = practiceRepository.findByPracticeId(request.getPracticeId());

	        if (patient == null || practiceInfo == null) {
	            throw new NotFoundException("Patient or Practice not found");
	        }

	        appointment.setPatient(patient);
	        appointment.setPracticeInfo(practiceInfo);
	        com.ca.patient.model.Appointment savedAppointment = appointmentRepository.save(appointment);

	        return Mono.just(AppointmentMapper.MAPPER.mapToAppointmentProtobuf(savedAppointment));
		} catch (Exception e) {
			log.error("Error occurred while creating appointment.", e);
	        throw new CustomException("Error occurred while creating appointment.", e);
		}
	}
}
