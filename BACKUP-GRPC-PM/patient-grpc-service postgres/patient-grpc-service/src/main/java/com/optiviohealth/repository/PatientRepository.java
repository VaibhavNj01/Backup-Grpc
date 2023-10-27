package com.optiviohealth.repository;

import com.optiviohealth.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
//    @Query("SELECT p FROM PatientEntity p WHERE p.practiceId = :practiceId AND p.externalPatientId = :externalPatientId")
//    com.optiviohealth.PatientEntity findByPracticeIdAndExternalPatientId(String practiceId, Long externalPatientId);
}
