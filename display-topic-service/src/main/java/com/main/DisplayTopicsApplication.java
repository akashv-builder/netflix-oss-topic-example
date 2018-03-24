package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients("com.main.showtopic")
public class DisplayTopicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayTopicsApplication.class, args);
	}
}
