package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_speciality")
@EqualsAndHashCode(callSuper = true)
public class SpecialityEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_speciality_speciality_id_seq", sequenceName = "ex_speciality_speciality_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_speciality_speciality_id_seq")
    @Column(name = "speciality_id")
    private Long specialityId;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "desc")
    private String desc;
}
