package com.demo.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class MessageConsumerListener {

	@KafkaListener(topics="demoTopic",groupId = "gp1",containerFactory ="listenerContainer" )
	 public void onMessage(EmployeeDTO emp) {
		 System.out.println(emp);
	 }
}
