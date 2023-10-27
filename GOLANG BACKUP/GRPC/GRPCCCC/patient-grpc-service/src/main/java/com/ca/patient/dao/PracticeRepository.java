package com.ca.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ca.patient.model.PracticeInfo;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeInfo, Long> {

	PracticeInfo findByPracticeId(Long practiceId);

}
