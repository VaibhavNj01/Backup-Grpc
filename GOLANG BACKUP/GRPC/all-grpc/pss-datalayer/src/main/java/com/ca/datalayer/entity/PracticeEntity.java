package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_practice")
@EqualsAndHashCode(callSuper = true)
public class PracticeEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_practice_practice_id_seq", sequenceName = "ex_practice_practice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_practice_practice_id_seq")
    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;
}
