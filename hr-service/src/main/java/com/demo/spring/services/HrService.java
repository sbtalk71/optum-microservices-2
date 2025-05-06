package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

@Service
public class HrService {

	private RestClient.Builder clientBuilder;

	public HrService(Builder clientBuilder) {
		this.clientBuilder = clientBuilder;
	}
	

	public String getEmpDetails(int id) {
		return clientBuilder.build()
				.get().
				uri("http://emp-service/emp/"+id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(String.class);
	}
}
