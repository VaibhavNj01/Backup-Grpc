package com.optiviohealth.mapper;


import com.optiviohealth.model.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper MAPPER = Mappers.getMapper(PatientMapper.class);

    com.optiviohealth.model.PatientEntity ProtoToModel(com.optiviohealth.PatientEntity request);

    com.optiviohealth.PatientResponse mapEntityToModelPostResponse(PatientEntity patientEntity);
}

