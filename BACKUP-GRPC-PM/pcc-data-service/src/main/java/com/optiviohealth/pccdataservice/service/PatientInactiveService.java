package com.optiviohealth.pccdataservice.service;

import com.optiviohealth.pccdataservice.PatientDetails;
import com.optiviohealth.pccdataservice.PatientInactiveRequest;
import com.optiviohealth.pccdataservice.PatientInactiveRequestByInactiveId;
import com.optiviohealth.pccdataservice.ReactorPatientInactiveServiceGrpc;
import com.optiviohealth.pccdataservice.mapper.PatientInactiveMapper;
import com.optiviohealth.pccdataservice.model.PatientInactiveEntity;
import com.optiviohealth.pccdataservice.repository.PatientInactiveRepository;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@GrpcService
@Log4j2
public class PatientInactiveService  extends ReactorPatientInactiveServiceGrpc.PatientInactiveServiceImplBase {

    private final PatientInactiveRepository patientInactiveRepository;
    private final PatientInactiveMapper patientInactiveMapper;

    @Autowired
    public PatientInactiveService(PatientInactiveRepository patientInactiveRepository, PatientInactiveMapper patientInactiveMapper) {
        this.patientInactiveRepository = patientInactiveRepository;
        this.patientInactiveMapper = patientInactiveMapper;
    }

    @Override
    public Mono<PatientDetails> getInActivePatientDetails(PatientInactiveRequest request) {
        PatientInactiveEntity patientInactiveEntity = patientInactiveRepository
                .findByExternalPatientIdAndPracticeId(request.getExternalPatientId(), request.getPracticeId())
                .block();
        if (patientInactiveEntity != null) {
            return Mono.just(patientInactiveMapper.mapEntityToProto(patientInactiveEntity));
        } else {
            return Mono.empty();
        }
        }
    @Override
    public Mono<PatientDetails> getInActivePatientDetailsByInactiveId(PatientInactiveRequestByInactiveId request) {
        PatientInactiveEntity patientInactiveEntity = patientInactiveRepository.findByPatientInactiveId(Long.valueOf((request.getId()))).block();
        return Mono.just(patientInactiveMapper.mapEntityToProto(patientInactiveEntity));
    }
}




