package com.ca.datalayer.repository;

import com.ca.datalayer.entity.PatientEntity;
import com.ca.datalayer.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<PatientEntity,Long> {

    Optional<PatientEntity> findByPatientId(Long patientId);
}
