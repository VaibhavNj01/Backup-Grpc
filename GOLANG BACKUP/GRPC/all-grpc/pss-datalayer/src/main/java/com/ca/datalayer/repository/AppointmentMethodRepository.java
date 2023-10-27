package com.ca.datalayer.repository;

import com.ca.datalayer.entity.AppointmentMethodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppointmentMethodRepository extends CrudRepository<AppointmentMethodEntity,Long> {

    Optional<AppointmentMethodEntity> findByName(String name);
}
