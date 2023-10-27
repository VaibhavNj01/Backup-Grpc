package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_location")
@EqualsAndHashCode(callSuper = true)
public class LocationEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_location_location_id_seq", sequenceName = "ex_location_location_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_location_location_id_seq")
    @Column(name = "location_id")
    private Long locationId;

    @JoinColumn(name = "address_id")
    @ManyToOne
    private AddressEntity address;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "direction_url")
    private String directionUrl;

    @Column(name = "time_zone")
    private String timezone;

}
