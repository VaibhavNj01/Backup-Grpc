package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_patient")
@EqualsAndHashCode(callSuper = true)
public class PatientEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_patient_patient_id_seq", sequenceName = "ex_patient_patient_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_patient_patient_id_seq")
    @Column(name = "patient_id", precision = 19)
    private Long patientId;

    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "person_id")
    private Long personId;
}
