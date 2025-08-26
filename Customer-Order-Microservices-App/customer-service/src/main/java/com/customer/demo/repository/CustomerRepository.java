package com.customer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer getCustomerByEmail(String email);
		
}
