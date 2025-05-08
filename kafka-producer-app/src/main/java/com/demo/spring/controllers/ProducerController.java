package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmployeeDTO;

@RestController
public class ProducerController {

	private KafkaTemplate<String, String> kafkaTemplate;
	
	public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@GetMapping(path="/send/{message}")
	public String sendMessage(@PathVariable String message) {
		kafkaTemplate.send("demoTopic", message);
		return "message sent";
	}
	
	
	//========//
	@Autowired
	@Qualifier("jsonKafkaTemplate")
	private KafkaTemplate<String, EmployeeDTO> jsonKafkaTemplate;
	@GetMapping(path="/sendJson")
	public String sendJsonMessage() {
		jsonKafkaTemplate.send("demoTopic", new EmployeeDTO(100, "Shantanu", "Hyderabad", 16000) );
		return "json message sent";
	}
	
}
