package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqExampleApplication {

//	disadvantage of RabbitMq
//	1)All the messages of one queue will be received by only one consumer(i.e, more than one consumer can consume one queue messages)
//	2)once it will listen by the consumer all the messages will be removed from the queues (so we are not able to back up the messages)
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqExampleApplication.class, args);
	}

}
