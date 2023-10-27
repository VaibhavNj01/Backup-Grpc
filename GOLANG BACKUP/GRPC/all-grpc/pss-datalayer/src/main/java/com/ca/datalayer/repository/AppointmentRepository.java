package com.ca.datalayer.repository;

import com.ca.datalayer.entity.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Long> {
    Optional<AppointmentEntity> findByAppointmentId(Long appointmentId);
}
