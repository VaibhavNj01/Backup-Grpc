package com.optiviohealth.pccdataservice.repository;

import com.optiviohealth.pccdataservice.model.InactivePatientEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InactivePatientRepository extends ReactiveMongoRepository<InactivePatientEntity, String> {


    @Query("{ '_id' : ?0 }")
    Mono<InactivePatientEntity> findByPatientInactiveId(ObjectId id);

    @Query("{'externalPatientId': ?0, 'practiceId': ?1}")
    Mono<InactivePatientEntity> findByExternalPatientIdAndPracticeId(String externalPatientId, String practiceId);
}
