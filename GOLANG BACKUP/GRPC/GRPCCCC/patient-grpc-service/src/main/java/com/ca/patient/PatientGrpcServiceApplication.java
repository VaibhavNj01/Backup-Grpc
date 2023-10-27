package com.ca.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientGrpcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientGrpcServiceApplication.class, args);
	}
	
//	@Bean
//    public LocalDateToDateConverter localDateToDateConverter() {
//        return new LocalDateToDateConverter();
//    }
}
