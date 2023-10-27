package com.optiviohealth.pccdataservice.mapper;


import com.optiviohealth.pccdataservice.*;
import com.optiviohealth.pccdataservice.model.InactivePatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface InactivePatientMapper {

    @Mapping(source = "dob", target = "dob", dateFormat = "yyyy-mm-dd")
    @Mapping(target = "guarantorDob", source = "guarantorDob", dateFormat = "yyyy-mm-dd")
    @Mapping(target = "active", source = "isActive")
    InactivePatientEntity mapProtoToObject(PatientRequest patientRequest);

    @Mapping(source = "_id", target = "id")
    PatientResponse mapObjectToResponse(InactivePatientEntity patientEntity);

    @Mapping(source = "dob", target = "dob", dateFormat = "yyyy-mm-dd")
    @Mapping(target = "guarantorDob", source = "guarantorDob", dateFormat = "yyyy-mm-dd")
    @Mapping(source = "id", target = "_id")
    @Mapping(target = "active", source = "isActive")
    InactivePatientEntity mapProtoToObjectUpdate(UpdatePatientRequest request);

    @Mapping(target = "dob", source = "dob", dateFormat = "yyyy-mm-dd")
    @Mapping(target = "guarantorDob", source = "guarantorDob", dateFormat = "yyyy-mm-dd")
    @Mapping(source = "_id", target = "id")
    @Mapping(target = "isActive", source = "active")
    PatientDetails mapEntityToProto(InactivePatientEntity inactivePatientEntity);

}
