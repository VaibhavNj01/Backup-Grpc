package com.optiviohealth.ReactiveGrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
@ComponentScan(value = "com.optiviohealth.ReactiveGrpc")
public class ReactiveGrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveGrpcApplication.class, args);
	}

}
