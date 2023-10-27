package com.optiviohealth.ReactiveGrpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Long id;
    private Long patientId;
    private Long practiceId;
    private LocalDateTime appointmentDateTime;
    private LocalDateTime appointmentCreationDateTime;
    private String status;
}
