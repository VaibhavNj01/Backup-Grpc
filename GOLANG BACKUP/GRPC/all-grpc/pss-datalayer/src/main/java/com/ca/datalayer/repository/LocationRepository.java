package com.ca.datalayer.repository;

import com.ca.datalayer.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<LocationEntity,Long> {

    Optional<LocationEntity> findByLocationId(Long locationId);
}
