package com.optiviohealth.pccdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient_inactive")
public class PatientInactiveEntity {
    @Field
    private String _id;
    @Field(name = "first_name")
    private String firstName;
    @Field(name = "middle_name")
    private String middleName;
    @Field(name = "last_name")
    private String lastName;
    @Field
    private Date dob;
    private String email;
    @Field(name = "mobile_phone")
    private String mobilePhone;
    @Field(name = "work_phone")
    private String workPhone;
    @Field(name = "home_phone")
    private String homePhone;
    @Field
    private String gender;
    @Field
    private String maritalStatus;
    @Field(name = "home_address1")
    private String homeAddress1;
    @Field(name = "home_address2")
    private String homeAddress2;
    @Field(name = "home_city")
    private String homeCity;
    @Field(name = "home_state")
    private String homeState;
    @Field(name = "home_country")
    private String homeCountry;
    @Field(name = "home_zipcode")
    private String homeZipcode;
    @Field(name = "practice_id")
    private String practiceId;
    @Field(name = "external_patient_id")
    private String externalPatientId;
    @Field(name = "created_by")
    private String createdBy;
    @Field
    @CreatedDate
    private Date createdTsz;
    @Field(name = "updated_by")
    private String updatedBy;
    @Field
    @LastModifiedDate
    private Date updatedTsz;
    @Field(name = "is_active")
    private boolean isActive;
    @Field(name = "emergency_contact")
    private String emergencyContact;
    @Field
    private String ssn;
    @Field(name = "work_address1")
    private String workAddress1;
    @Field(name = "work_address2")
    private String workAddress2;
    @Field(name = "work_city")
    private String workCity;
    @Field(name = "work_state")
    private String workState;
    @Field(name = "work_country")
    private String workCountry;
    @Field(name = "work_zipcode")
    private String workZipcode;
    @Field(name = "guarantor_email")
    private String guarantorEmail;
    @Field(name = "guarantor_first_name")
    private String guarantorFirstName;
    @Field(name = "guarantor_last_name")
    private String guarantorLastName;
    @Field
    private Date guarantorDob;
    @Field(name = "guarantor_ssn")
    private String guarantorSsn;
    @Field
    private String language;
}
