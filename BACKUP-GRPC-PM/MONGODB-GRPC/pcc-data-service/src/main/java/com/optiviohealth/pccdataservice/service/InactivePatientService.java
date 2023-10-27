package com.optiviohealth.pccdataservice.service;


import com.optiviohealth.pccdataservice.*;
import com.optiviohealth.pccdataservice.mapper.InactivePatientMapper;
import com.optiviohealth.pccdataservice.model.InactivePatientEntity;
import com.optiviohealth.pccdataservice.repository.InactivePatientRepository;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Date;

@GrpcService
@Log4j2
public class InactivePatientService extends ReactorPatientServiceGrpc.PatientServiceImplBase {
    private final InactivePatientRepository patientRepository;
    private final InactivePatientMapper patientMapper;

    @Autowired
    public InactivePatientService(InactivePatientRepository patientRepository, InactivePatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public Mono<PatientResponse> createNewPatient(PatientRequest request) {
        InactivePatientEntity patientEntity = patientMapper.mapProtoToObject(request);
        patientEntity.setCreatedTsz(new Date());

        return patientRepository.save(patientEntity)
                .map(savedPatientEntity -> {

                    PatientResponse patientResponse = patientMapper.mapObjectToResponse(savedPatientEntity);
                    PatientResponse response = PatientResponse.newBuilder()
                            .setId(patientEntity.get_id())
                            .setMessage("Patient created successfully")
                            .build();
                    return response;

                });
    }

    @Override
    public Mono<UpdatePatientResponse> updateInactivePatient(UpdatePatientRequest request) {
        InactivePatientEntity entity = patientMapper.mapProtoToObjectUpdate(request);
        entity.setUpdatedTsz(new Date());

        Mono<InactivePatientEntity> updatedEntityMono = patientRepository.save(entity);

        return updatedEntityMono.map(updatedEntity -> {
            UpdatePatientResponse response = UpdatePatientResponse.newBuilder()
                    .setId(updatedEntity.get_id())
                    .setMessage("Patient Updated succesfully")
                    .build();
            return response;
        });
    }

    @Override
    public Mono<PatientDetails> getInActivePatientDetailsByInactiveId(PatientInactiveRequestByInactiveId request) {
        return patientRepository.findByPatientInactiveId(new ObjectId(request.getId()))
                .map(patientMapper::mapEntityToProto);
    }

    @Override
    public Mono<PatientDetails> getInactivePatientDetails(PatientInactiveRequest request) {
        InactivePatientEntity patientInactiveEntity = patientRepository
                .findByExternalPatientIdAndPracticeId(request.getExternalPatientId(), request.getPracticeId())
                .block();
        if (patientInactiveEntity != null) {
            return Mono.just(patientMapper.mapEntityToProto(patientInactiveEntity));
        } else {
            return Mono.empty();
        }
    }
}

