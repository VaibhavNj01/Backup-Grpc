package com.pp.SpringReactiveProto;

import com.pp.SpringReactiveProto.controller.UserController;
import com.pp.SpringReactiveProto.repository.UserRepository;
import com.pp.SpringReactiveProto.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class SpringReactiveProtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProtoApplication.class, args);
	}

}
