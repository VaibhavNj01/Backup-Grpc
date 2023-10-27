package com.ca.datalayer.repository;

import com.ca.datalayer.entity.ProviderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProviderRepository extends CrudRepository<ProviderEntity,Long> {

    Optional<ProviderEntity> findByProviderId(Long providerId);
}
