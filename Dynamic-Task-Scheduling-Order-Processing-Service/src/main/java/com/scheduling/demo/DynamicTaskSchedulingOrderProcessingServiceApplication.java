package com.scheduling.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DynamicTaskSchedulingOrderProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicTaskSchedulingOrderProcessingServiceApplication.class, args);
	}

}
