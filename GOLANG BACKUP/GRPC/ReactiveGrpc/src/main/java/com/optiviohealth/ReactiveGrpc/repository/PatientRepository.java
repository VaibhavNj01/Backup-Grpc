package com.optiviohealth.ReactiveGrpc.repository;

import com.optiviohealth.ReactiveGrpc.entity.PatientEntity;
import com.optiviohealth.ReactiveGrpc.model.Patient;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends R2dbcRepository<PatientEntity, Long> {
}
