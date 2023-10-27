package com.pp.SpringReactiveProto.service;

import com.pp.SpringReactiveProto.entity.UserEntity;
import com.pp.SpringReactiveProto.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import src.main.proto.User;
import src.main.proto.UserServiceGrpc;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User request, StreamObserver<User> responseObserver) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setEmail(request.getEmail());

        Mono<UserEntity> savedUserMono = userRepository.save(userEntity);

        savedUserMono.subscribe(savedUser -> {
            User response = User.newBuilder()
                    .setId(savedUser.getId())
                    .setName(savedUser.getName())
                    .setEmail(savedUser.getEmail())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        });
    }

    @Override
    public void updateUser(User request, StreamObserver<User> responseObserver) {
        // Implement logic to update a user
    }

    @Override
    public void getUser(User request, StreamObserver<User> responseObserver) {
        // Implement logic to get a user by ID
    }

    @Override
    public void deleteUser(User request, StreamObserver<User> responseObserver) {
        // Implement logic to delete a user
    }
}
