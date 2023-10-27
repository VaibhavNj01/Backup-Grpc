package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_practice_location")
@EqualsAndHashCode(callSuper = true)
public class PracticeLocationEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_practice_location_practice_location_id_seq", sequenceName = "ex_practice_location_practice_location_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_practice_location_practice_location_id_seq")
    @Column(name = "practice_location_id", precision = 19)
    private Long practiceLocationId;

    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "location_id")
    private Long locationId;
}
