package com.ca.patient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ca.patient.CreatePatientRequest;
import com.ca.patient.model.PatientInfo;

@Mapper(componentModel = "spring")
public interface PatientMapper {

	PatientMapper MAPPER = Mappers.getMapper(PatientMapper.class);

	//@Mapping(target = "dob", dateFormat = "yyyy-MM-dd")
	//com.ca.patient.model.PatientInfo mapCreatePatientRequestToPatientInfo(CreatePatientRequest patientInfo);

//	default Mono<PatientInfo> mapToMonoGrpcPatientInfo(Mono<com.ca.patient.model.PatientInfo> monoPatient) {
//		return monoPatient.map(patientInfoModel -> {
//			return mapToPatientInfoProtobuf(patientInfoModel);
//		});
//	}

	//@Mapping(target = "dob", dateFormat = "yyyy-MM-dd")
	//PatientInfo mapToPatientInfoProtobuf(com.ca.patient.model.PatientInfo patientInfo);
	
	@Mapping(target = "dob", dateFormat = "dd-MM-yyyy")
	com.ca.patient.PatientInfo mapToGrpcPatientInfoObject(PatientInfo patientInfo);

	@Mapping(target = "dob", dateFormat = "dd-MM-yyyy")
	PatientInfo mapToPatientInfoObject(CreatePatientRequest patientInfo);

}