package com.optiviohealth.ReactiveGrpc.mapper;

import com.optiviohealth.ReactiveGrpc.entity.PatientEntity;
import com.optiviohealth.ReactiveGrpc.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientEntity mapToEntity(Patient patient);
    Patient mapToModel(PatientEntity patient);
}
