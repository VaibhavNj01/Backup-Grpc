package com.optiviohealth.ReactiveGrpc.repository;

import com.optiviohealth.ReactiveGrpc.entity.PracticeEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends R2dbcRepository<PracticeEntity, Long> {
}
