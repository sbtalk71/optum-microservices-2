package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userManager= new InMemoryUserDetailsManager();
		userManager.createUser(User.withUsername("shantanu").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("ADMIN").build());
		userManager.createUser(User.withUsername("pavan").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("USER").build());
		userManager.createUser(User.withUsername("rajesh").password("$2a$10$KJ5fD.A3jvoTLALJ.09hUeJZvsd.i83K2lx4XiUOrQo8kqZfaGbOS").roles("OTHER").build());
		return userManager;
	}
	
}
