package com.optiviohealth.ReactiveGrpc.service;

import com.optiviohealth.ReactiveGrpc.entity.AppointmentEntity;
import com.optiviohealth.ReactiveGrpc.mapper.AppointmentMapper;
import com.optiviohealth.ReactiveGrpc.model.Appointment;
import com.optiviohealth.ReactiveGrpc.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
@Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public Mono<Appointment> createAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity = appointmentMapper.mapToEntity(appointment);
        return appointmentRepository.save(appointmentEntity)
                .map(appointmentMapper::mapToModel);
    }

    public Mono<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .map(appointmentMapper::mapToModel);
    }

    public Flux<Appointment> getAllAppointments() {
        return appointmentRepository.findAll()
                .map(appointmentMapper::mapToModel);
    }

//    public Mono<Appointment> updateAppointment(Long id, Appointment appointment) {
//        return appointmentRepository.findById(id)
//                .flatMap(existingAppointment -> {
//                    AppointmentEntity updatedAppointment = appointmentMapper.mapToEntity(appointment);
//                    existingAppointment.setPatientEntity(updatedAppointment.getPatientEntity());
//                    existingAppointment.setPracticeEntity(updatedAppointment.getPracticeEntity());
//                    existingAppointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
//                    existingAppointment.setAppointmentCreationDateTime(updatedAppointment.getAppointmentCreationDateTime());
//                    existingAppointment.setStatus(updatedAppointment.getStatus());
//                    return appointmentRepository.save(existingAppointment);
//                })
//                .map(appointmentMapper::mapToModel);
//    }

    public Mono<Void> deleteAppointment(Long id) {
        return appointmentRepository.deleteById(id);
    }
}
