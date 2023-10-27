package com.optiviohealth.pccdataservice.repository;

import com.optiviohealth.pccdataservice.model.PatientInactiveEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface PatientInactiveRepository extends ReactiveMongoRepository<PatientInactiveEntity,Long> {

    @Query("{'externalPatientId': ?0, 'practiceId': ?1}")
    Mono<PatientInactiveEntity> findByExternalPatientIdAndPracticeId(String externalPatientId, String practiceId);

    @Query("{ 'patient_inactive_id' : ?0 }")
    Mono<PatientInactiveEntity> findByPatientInactiveId(Long patientInactiveId);
}
