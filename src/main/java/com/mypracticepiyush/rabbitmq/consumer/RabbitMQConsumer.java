package com.mypracticepiyush.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consumer(String message) {
		System.out.println("Recieved message : " + message);
	}
}
