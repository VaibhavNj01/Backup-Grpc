package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_provider")
@EqualsAndHashCode(callSuper = true)
public class ProviderEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_provider_provider_id_seq", sequenceName = "ex_provider_provider_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_provider_provider_id_seq")
    @Column(name = "provider_id")
    private Long providerId;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "experience")
    private String experience;

    @Column(name = "language_spoken")
    private String language_spoken;

    @Column(name = "active")
    private boolean active;
}
