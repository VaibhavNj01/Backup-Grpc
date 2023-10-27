package com.optiviohealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.optiviohealth.repository", "com.optiviohealth.config"})
public class PatientGrpcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientGrpcServiceApplication.class, args);
	}

}
