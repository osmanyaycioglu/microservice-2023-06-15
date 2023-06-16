package com.microservices.training.msnotify;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class MsNotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNotifyApplication.class, args);
	}

}
