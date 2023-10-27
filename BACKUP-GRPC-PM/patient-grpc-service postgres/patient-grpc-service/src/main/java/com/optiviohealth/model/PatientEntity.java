package com.optiviohealth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1,initialValue = 1000)
    @Column(name = "patient_inactive_id")
    private Long patientInactiveId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Long mobilePhone;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private Long externalPatientId;
    private Long practiceId;
}
