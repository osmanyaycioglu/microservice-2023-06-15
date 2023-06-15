package com.microservices.training.nodediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaServer
@EnableScheduling
public class NodeDiscoveryApplication {

	private int counter = 0;

	@Scheduled(fixedDelay = 10_000)
	public void testSchedule(){
		System.out.println("çalıştım : " + counter++);
	}

	public static void main(String[] args) {
		SpringApplication.run(NodeDiscoveryApplication.class, args);
	}

}
