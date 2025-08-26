package com.customer.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.customer.demo.entity.Customer;
import com.customer.demo.exception.CustomerAlreadyExistsException;
import com.customer.demo.exception.CustomerNotFoundException;
import com.customer.demo.repository.CustomerRepository;
import com.customer.demo.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		Optional<Customer> optCust= customerRepository.findById(id);
		if(optCust.isEmpty()) throw new CustomerNotFoundException(id);
		return optCust;
	}

	@Override
	public Customer createCustomer(Customer newCustomer) {
		Customer customer=  customerRepository.getCustomerByEmail(newCustomer.getEmail());
		if(customer!=null) throw new CustomerAlreadyExistsException(newCustomer.getEmail());
			return customerRepository.save(newCustomer);
	}

	@Override
	public Customer updateCustomer(Customer newCustomer, Long id) {
		Optional<Customer> custOptional=customerRepository.findById(id);
		Customer custObj=null;
		if(custOptional.isPresent()) {
			custObj=custOptional.get();
			custObj.setName(newCustomer.getName());
			custObj.setEmail(newCustomer.getEmail());
			custObj.setLocation(newCustomer.getLocation());
			return customerRepository.save(custObj);
		}
		throw new CustomerNotFoundException(id);
		
	}

	@Override
	public String deleteCustomer(Long id) {
		Optional<Customer> custOptional=customerRepository.findById(id);
		Customer custObj=null;
		String deleteMsg=null;
		if(custOptional.isPresent()) {
			custObj=custOptional.get();
			customerRepository.delete(custObj);
			deleteMsg="Customer Successfully Deleted for id:"+id;
		}
		return deleteMsg;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.getCustomerByEmail(email);
	}


}
