package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EmpApiGatewayMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpApiGatewayMvcApplication.class, args);
	}

	@GetMapping({"error-message","emp-service-message"})
	public String serviceMessage() {
		return "{\"status\":\"Service Unavailable\"}";
	}
}
