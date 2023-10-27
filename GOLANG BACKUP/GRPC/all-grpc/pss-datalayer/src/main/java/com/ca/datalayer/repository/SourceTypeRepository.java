package com.ca.datalayer.repository;

import com.ca.datalayer.entity.SourceTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SourceTypeRepository extends CrudRepository<SourceTypeEntity,Long> {

    Optional<SourceTypeEntity> findByName(String name);
}
