package com.microservices.training.apigworder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApigwOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigwOrderApplication.class, args);
	}

}
