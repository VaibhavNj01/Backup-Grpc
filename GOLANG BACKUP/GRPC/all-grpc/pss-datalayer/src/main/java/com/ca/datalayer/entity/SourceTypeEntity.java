package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="source_type")
@EqualsAndHashCode(callSuper = true)
public class SourceTypeEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "source_type_source_type_id_seq", sequenceName = "source_type_source_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_type_source_type_id_seq")
    @Column(name = "source_type_id")
    private Long sourceTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;
}
