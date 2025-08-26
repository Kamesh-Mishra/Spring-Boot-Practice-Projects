package com.customer.demo.service;

import java.util.List;
import java.util.Optional;

import com.customer.demo.entity.Customer;

public interface CustomerService {
	
	List<Customer> fetchAllCustomers();
	
	Optional<Customer> getCustomerById(Long id);
	
	Customer getCustomerByEmail(String email);
	
	Customer createCustomer(Customer newCustomer);
	
	Customer updateCustomer(Customer newCustomer, Long id);
	
	String deleteCustomer(Long id);

}
