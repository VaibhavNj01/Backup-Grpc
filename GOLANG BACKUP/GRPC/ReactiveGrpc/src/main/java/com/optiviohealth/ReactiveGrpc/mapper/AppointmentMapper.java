package com.optiviohealth.ReactiveGrpc.mapper;

import com.optiviohealth.ReactiveGrpc.entity.AppointmentEntity;
import com.optiviohealth.ReactiveGrpc.entity.PracticeEntity;
import com.optiviohealth.ReactiveGrpc.model.Appointment;
import com.optiviohealth.ReactiveGrpc.model.Practice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentEntity mapToEntity(Appointment appointment);
    Appointment mapToModel(AppointmentEntity appointment);
}
