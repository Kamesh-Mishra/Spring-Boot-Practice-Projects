package com.order.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.demo.model.Customer;

@FeignClient(name="customer-service", url="http://localhost:9001")
public interface CustomerClient {

	@GetMapping("/customers/{id}")
	Customer getCustomerById(@PathVariable Long id);

}
