package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ex_address")
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_address_address_id_seq", sequenceName = "ex_address_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_address_address_id_seq")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_line_3")
    private String addressLine3;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "country")
    private String country;

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;
}
