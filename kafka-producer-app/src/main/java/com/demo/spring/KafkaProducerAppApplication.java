package com.demo.spring;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@SpringBootApplication
public class KafkaProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerAppApplication.class, args);
	}

 @Bean
 ProducerFactory<String, String> producerFactory(){
	 HashMap<String, Object> config=new HashMap<>();
	 config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	 config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	 config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	 return new DefaultKafkaProducerFactory<>(config);
 }
 
 @Bean
 KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String,String> factory){
	 return new KafkaTemplate<>(factory);
 }
 
 
 @Bean
 ProducerFactory<String, EmployeeDTO> jsonFroducerFactory(){
	 HashMap<String, Object> config=new HashMap<>();
	 config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	 config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	 config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	 return new DefaultKafkaProducerFactory<>(config);
 }
 
 
 @Bean
 KafkaTemplate<String, EmployeeDTO> jsonKafkaTemplate(@Qualifier("jsonFroducerFactory") ProducerFactory<String,EmployeeDTO> factory){
	 return new KafkaTemplate<>(factory);
 }
}
