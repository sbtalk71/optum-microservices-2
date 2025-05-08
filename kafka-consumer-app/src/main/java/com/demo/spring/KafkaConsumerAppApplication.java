package com.demo.spring;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;



@SpringBootApplication
public class KafkaConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerAppApplication.class, args);
	}

 
 
 @Bean
 ConsumerFactory<String, EmployeeDTO> jsonConsumerFactory(){
	 HashMap<String, Object> config=new HashMap<>();
	 config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	 config.put(ConsumerConfig.GROUP_ID_CONFIG, "gp1");
	 config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	 config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	 config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
	 return new DefaultKafkaConsumerFactory<>(config);
 }
 
 
 @Bean
 ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> listenerContainer(){
	 ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> lc= new ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO>();
	 lc.setConsumerFactory(jsonConsumerFactory());
	 return lc;
 }
 
 
 
}
