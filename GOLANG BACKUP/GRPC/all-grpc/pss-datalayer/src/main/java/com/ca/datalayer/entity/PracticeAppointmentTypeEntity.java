package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_practice_appointment_type")
@EqualsAndHashCode(callSuper = true)
public class PracticeAppointmentTypeEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_practice_appointment_type_practice_appointment_type_id_seq", sequenceName = "ex_practice_appointment_type_practice_appointment_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_practice_appointment_type_practice_appointment_type_id_seq")
    @Column(name = "practice_appointment_type_id", precision = 19)
    private Long practiceAppointmentTypeId;

    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "appointment_type_id")
    private Long appointmentTypeId;
}


