package com.pp.SpringReactiveProto.controller;

import com.pp.SpringReactiveProto.entity.UserEntity;
import com.pp.SpringReactiveProto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<UserEntity> createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @PutMapping
    public Mono<UserEntity> updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }

    @GetMapping("/{userId}")
    public Mono<UserEntity> getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    public Mono<Void> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
