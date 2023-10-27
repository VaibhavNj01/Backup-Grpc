package com.optiviohealth.ReactiveGrpc.entity;

import com.optiviohealth.ReactiveGrpc.model.Patient;
import com.optiviohealth.ReactiveGrpc.model.Practice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")

public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id") // Define the foreign key column name
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "practice_id") // Define the foreign key column name
    private PracticeEntity practiceEntity;

    private LocalDateTime appointmentDateTime;
    private LocalDateTime appointmentCreationDateTime;
    private String status;
}
