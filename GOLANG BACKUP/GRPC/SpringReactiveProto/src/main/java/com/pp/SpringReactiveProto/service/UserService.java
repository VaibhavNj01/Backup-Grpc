package com.pp.SpringReactiveProto.service;

import com.pp.SpringReactiveProto.entity.UserEntity;
import com.pp.SpringReactiveProto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<UserEntity> createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Mono<UserEntity> updateUser(UserEntity user) {
        return userRepository.findById(user.getId())
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                })
                .switchIfEmpty(Mono.error(new Exception("User not found")));
    }

    public Mono<UserEntity> getUser(Long userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new Exception("User not found")));
    }

    public Mono<Void> deleteUser(Long userId) {
        return userRepository.findById(userId)
                .flatMap(existingUser -> userRepository.delete(existingUser))
                .then();
    }

    public Flux<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
