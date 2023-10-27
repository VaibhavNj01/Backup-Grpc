package com.optiviohealth.ReactiveGrpc.repository;

import com.optiviohealth.ReactiveGrpc.entity.AppointmentEntity;
import com.optiviohealth.ReactiveGrpc.model.Appointment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AppointmentRepository extends ReactiveCrudRepository<AppointmentEntity, Long> {
}
