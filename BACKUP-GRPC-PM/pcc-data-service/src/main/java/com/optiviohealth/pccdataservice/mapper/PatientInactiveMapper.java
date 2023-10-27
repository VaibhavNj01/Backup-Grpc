package com.optiviohealth.pccdataservice.mapper;

import com.optiviohealth.pccdataservice.PatientDetails;
import com.optiviohealth.pccdataservice.model.PatientInactiveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientInactiveMapper {
    @Mapping(target = "id", source = "_id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "mobilePhone", source = "mobilePhone")
    @Mapping(target = "workPhone", source = "workPhone")
    @Mapping(target = "homePhone", source = "homePhone")
    @Mapping(target = "maritalStatus", source = "maritalStatus")
    @Mapping(target = "homeAddress1", source = "homeAddress1")
    @Mapping(target = "homeAddress2", source = "homeAddress2")
    @Mapping(target = "homeCity", source = "homeCity")
    @Mapping(target = "homeState", source = "homeState")
    @Mapping(target = "homeCountry", source = "homeCountry")
    @Mapping(target = "homeZipcode", source = "homeZipcode")
    @Mapping(target = "practiceId", source = "practiceId")
    @Mapping(target = "externalPatientId", source = "externalPatientId")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "isActive", source = "active")
    @Mapping(target = "emergencyContact", source = "emergencyContact")
    @Mapping(target = "workAddress1", source = "workAddress1")
    @Mapping(target = "workAddress2", source = "workAddress2")
    @Mapping(target = "workCity", source = "workCity")
    @Mapping(target = "workState", source = "workState")
    @Mapping(target = "workCountry", source = "workCountry")
    @Mapping(target = "workZipcode", source = "workZipcode")
    @Mapping(target = "guarantorEmail", source = "guarantorEmail")
    @Mapping(target = "guarantorFirstName", source = "guarantorFirstName")
    @Mapping(target = "guarantorLastName", source = "guarantorLastName")
    @Mapping(target = "guarantorSsn", source = "guarantorSsn")
    @Mapping(target = "language", source = "language")
    @Mapping(target = "dob",source = "dob", dateFormat ="yyyy-mm-dd" )
    @Mapping(target = "guarantorDob",source = "guarantorDob", dateFormat ="yyyy-mm-dd" )

    PatientDetails mapEntityToProto(PatientInactiveEntity patientInactiveEntity);

}

