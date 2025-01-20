package com.mypracticepiyush.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	//all spring beans can be defined in this class.
	
	//read queue name from properties files.
	@Value("${rabbitmq.queue.name}")
	private String queueName;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	
	//spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchangeName);
	}
	
	@Bean
	public Binding bind() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}
	
	/*
	 * To be able to communicate with RabbitMQ broker other than queue, exchange and binding, it is required to 
	 * configure other infrastructure bean like :
	 * connectionFactory,
	 * rabbitTemplate
	 * rabbitAdmin.
	 * 
	 *  Spring boot's auto configuration will configure these with default values.
	 * */
}
