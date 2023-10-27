package com.optiviohealth.pccdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient_inactive")
public class InactivePatientEntity {

    private String _id;
    @Field
    private String firstName;
    @Field
    private String middleName;
    @Field
    private String lastName;
    @Field
    private Date dob;
    @Field
    private String email;
    @Field
    private String mobilePhone;
    @Field
    private String workPhone;
    @Field
    private String homePhone;
    @Field
    private String gender;
    @Field
    private String maritalStatus;
    @Field
    private String homeAddress1;
    @Field
    private String homeAddress2;
    @Field
    private String homeCity;
    @Field
    private String homeState;
    @Field
    private String homeCountry;
    @Field
    private String homeZipCode;
    @Field
    private String practiceId;
    @Field
    private String externalPatientId;
    @Field
    private String createdBy;
    @Field
    @CreatedDate
    private Date createdTsz;
    @Field
    private String updatedBy;
    @Field
    @LastModifiedDate
    private Date updatedTsz;
    @Field(name = "is_active")
    private boolean isActive;
    @Field
    private String emergencyContact;
    @Field
    private String ssn;
    @Field
    private String workAddress1;
    @Field
    private String workAddress2;
    @Field
    private String workCity;
    @Field
    private String workState;
    @Field
    private String workCountry;
    @Field
    private String workZipCode;
    @Field
    private String guarantorEmail;
    @Field
    private String guarantorFirstName;
    @Field
    private String guarantorLastName;
    @Field
    private Date guarantorDob;

    @Field
    private String guarantorSsn;
    @Field
    private String language;
}
