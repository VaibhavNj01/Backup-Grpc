package com.ca.patient.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ca.patient.CreatePatientRequest;
import com.ca.patient.GetPatientByRequest;
import com.ca.patient.PatientInfo;
import com.ca.patient.ReactorPatientServiceGrpc;
import com.ca.patient.dao.PatientRepository;
import com.ca.patient.exception.NotFoundException;
import com.ca.patient.mapper.PatientMapper;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import reactor.core.publisher.Mono;

@GrpcService
@Slf4j
public class PatientInfoService extends ReactorPatientServiceGrpc.PatientServiceImplBase {

	private final PatientRepository repo;

	@Autowired
	public PatientInfoService(PatientRepository repo) {
		this.repo = repo;
	}

	@Override
	public Mono<PatientInfo> getPatientById(GetPatientByRequest request) {
		com.ca.patient.model.PatientInfo patientInfo = repo.findByPatientId(request.getPatientId());
		if (patientInfo == null) {
			throw new NotFoundException("Patient not found");
		}
		return Mono.just(PatientMapper.MAPPER.mapToGrpcPatientInfoObject(patientInfo));
	}

	@Override
	public Mono<PatientInfo> createPatient(CreatePatientRequest request) {
		try {
			com.ca.patient.model.PatientInfo patientInfo = repo
					.save(PatientMapper.MAPPER.mapToPatientInfoObject(request));
			return Mono.just(PatientMapper.MAPPER.mapToGrpcPatientInfoObject(patientInfo));
		} catch (Exception e) {
			log.error("Error creating patient", e);
			throw new RuntimeException("Error creating patient", e);
		}
	}
}
