package com.optiviohealth.pccdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
//@ComponentScan(basePackages = {"com.optiviohealth.pccdataservice.repository","com.optiviohealth.pccdataservice.config"})
public class PccDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PccDataServiceApplication.class, args);
	}

}
