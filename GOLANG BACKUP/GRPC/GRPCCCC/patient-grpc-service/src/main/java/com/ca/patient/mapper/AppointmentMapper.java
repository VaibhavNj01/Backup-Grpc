package com.ca.patient.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ca.patient.Appointment;
import com.ca.patient.CreateAppointmentRequest;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

	AppointmentMapper MAPPER = Mappers.getMapper(AppointmentMapper.class);
	
	Appointment mapToAppointmentProtobuf(com.ca.patient.model.Appointment appointment);

	List<Appointment> mapToAppointmentProtobuf(List<com.ca.patient.model.Appointment> appointments);

	com.ca.patient.model.Appointment mapToAppointmentModel(CreateAppointmentRequest request);
}
