package com.ca.datalayer.repository;

import com.ca.datalayer.entity.AppointmentTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppointmentTypeRepository extends CrudRepository<AppointmentTypeEntity,Long> {

    Optional<AppointmentTypeEntity> findByName(String name);
}
