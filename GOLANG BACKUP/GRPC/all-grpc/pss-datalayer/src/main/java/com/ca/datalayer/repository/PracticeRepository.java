package com.ca.datalayer.repository;

import com.ca.datalayer.entity.PracticeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PracticeRepository extends CrudRepository<PracticeEntity,Long> {

    Optional<PracticeEntity> findByPracticeId(Long practiceId);
}
