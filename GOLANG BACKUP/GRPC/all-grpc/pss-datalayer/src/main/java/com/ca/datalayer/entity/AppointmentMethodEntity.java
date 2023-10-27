package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="appointment_method")
@EqualsAndHashCode(callSuper = true)
public class AppointmentMethodEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "appointment_method_id_seq", sequenceName = "appointment_method_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_method_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;
}
