package com.pp.SpringReactiveProto.repository;

import com.pp.SpringReactiveProto.entity.UserEntity;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
}
