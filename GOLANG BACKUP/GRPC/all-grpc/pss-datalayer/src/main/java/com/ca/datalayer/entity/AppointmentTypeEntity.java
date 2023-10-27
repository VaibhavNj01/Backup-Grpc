package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ex_appointment_type")
@EqualsAndHashCode(callSuper = true)
public class AppointmentTypeEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_appointment_type_appointment_type_id_seq", sequenceName = "ex_appointment_type_appointment_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_appointment_type_appointment_type_id_seq")
    @Column(name = "appointment_type_id")
    private Long appointmentTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

}
