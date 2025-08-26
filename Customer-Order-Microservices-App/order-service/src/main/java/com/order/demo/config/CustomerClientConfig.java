package com.order.demo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.demo.exception.CustomProblemDetail;
import com.order.demo.exception.CustomerNotFoundException;

import feign.Util;
import feign.codec.ErrorDecoder;

@Configuration
public class CustomerClientConfig {

	@Bean
	public ErrorDecoder errorDecoder() {
		return (methodKey, response) -> {
			try {
				if (response.body() == null) {
					return new RuntimeException("No response body");
				}

				// Convert body to string safely
				String body = Util.toString(response.body().asReader());

				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.findAndRegisterModules();

				// Deserialize into ProblemDetail
				CustomProblemDetail error = objectMapper.readValue(body, CustomProblemDetail.class);				
				// Check and extract custom fields
				if (response.status() == 404 && 
						"CUSTOMER_NOT_FOUND".equals(error.getErrorCode())) {

					Long customerId = ((Number) error.getCustomerId()).longValue();
					throw new CustomerNotFoundException(error.getDetail());
				}

				return new RuntimeException("Unhandled error: " + error.getDetail());

			} catch (IOException e) {
				return new RuntimeException("Error decoding error response", e);
			}
		};
	}
}