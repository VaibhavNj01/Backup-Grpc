package com.ca.patient.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long appointmentId;

	@ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
	private PatientInfo patient;

	@ManyToOne
    @JoinColumn(name = "practice_id", referencedColumnName = "id")
	private PracticeInfo practiceInfo;

	@Column(name = "appointment_date_time")
	private LocalDateTime appointmentDateTime;

	@Column(name = "appointment_creation_date_time")
	private LocalDateTime appointmentCreationDateTime;

	@Column(name = "status")
	private String status;
}
