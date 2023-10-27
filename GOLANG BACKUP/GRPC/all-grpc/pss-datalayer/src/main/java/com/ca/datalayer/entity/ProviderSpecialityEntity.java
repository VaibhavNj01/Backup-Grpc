package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_provider_speciality")
@EqualsAndHashCode(callSuper = true)
public class ProviderSpecialityEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_provider_speciality_provider_speciality_id_seq", sequenceName = "ex_provider_speciality_provider_speciality_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_provider_speciality_provider_speciality_id_seq")
    @Column(name = "provider_speciality_id")
    private Long providerSpecialityId;

    @Column(name = "speciality_id")
    private Long specialityId;

    @Column(name = "provider_id")
    private Long providerId;
}
