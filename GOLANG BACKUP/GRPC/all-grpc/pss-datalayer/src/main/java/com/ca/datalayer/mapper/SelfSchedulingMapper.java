package com.ca.datalayer.mapper;

import com.ca.datalayer.entity.AppointmentEntity;
import com.ca.selfscheduling.AppointmentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SelfSchedulingMapper {

    SelfSchedulingMapper MAPPER= Mappers.getMapper(SelfSchedulingMapper.class);

    @Mapping(target = "appointmentType",source = "appointmentEntity.appointmentType.name")
    @Mapping(target = "location.address",source="appointmentEntity.location.address")
    AppointmentDetail mapAppointmentDetail(AppointmentEntity appointmentEntity);
}
