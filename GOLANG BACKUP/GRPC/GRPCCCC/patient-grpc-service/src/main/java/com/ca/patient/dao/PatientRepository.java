package com.ca.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ca.patient.model.PatientInfo;

@Repository
public interface PatientRepository extends JpaRepository<PatientInfo, Long> {

	public PatientInfo findByPatientId(Long patientId);

}
