package com.mypracticepiyush.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mypracticepiyush.rabbitmq.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	private RabbitMQProducer producer;
	
	public MessageController(RabbitMQProducer producer) {
		this.producer = producer;
	}
	
	//http://localhost:8080/api/v1/publis?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> getMessage(@RequestParam("message") String message) {
		
		producer.sendMessage(message);
		
		return ResponseEntity.ok("message sent successfully");
	}
}
