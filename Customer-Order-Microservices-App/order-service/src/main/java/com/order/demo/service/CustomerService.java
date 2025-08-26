package com.order.demo.service;

import org.springframework.stereotype.Service;

import com.order.demo.client.CustomerClient;
import com.order.demo.exception.CustomerNotFoundException;
import com.order.demo.model.Customer;
import com.order.demo.model.CustomerResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {
	
	private final CustomerClient customerClient;
	
	@CircuitBreaker(name="customerServiceCB", fallbackMethod="fallbackGetCustomer")
	public CustomerResponse getCustomer(Long id) {
		CustomerResponse customerResponse=new CustomerResponse();
		Customer customer=customerClient.getCustomerById(id);
		if(customer!=null) {
			customerResponse.setCustomer(customer);
			customerResponse.setIsError(false);
		}
		return  customerResponse;
	}
	
	public CustomerResponse fallbackGetCustomer(Long id, Throwable t) {
		CustomerResponse customerResponse=new CustomerResponse();
		if(t instanceof CustomerNotFoundException) {
			customerResponse.setIsError(true);
			customerResponse.setErrorMsg(t.getMessage());
		}else {
			customerResponse.setIsError(true);
			customerResponse.setErrorMsg("Customer Service Temporarily Unavailable. Please try later.");
		}
		
		return customerResponse;
	}

}
