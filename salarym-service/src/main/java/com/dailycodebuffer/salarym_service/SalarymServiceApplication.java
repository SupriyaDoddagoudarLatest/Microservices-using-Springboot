package com.dailycodebuffer.salarym_service;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalarymServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalarymServiceApplication.class, args);
	}

}
