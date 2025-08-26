package com.order.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.entity.Orders;
import com.order.demo.model.CustomerResponse;
import com.order.demo.service.CustomerService;
import com.order.demo.service.OrderService;

import lombok.RequiredArgsConstructor;


@RestController
public class OrderController {

	private final CustomerService customerService;
	private final OrderService orderService;
	
	public OrderController(CustomerService customerService, OrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@PostMapping("/orders/placeorder")
	public ResponseEntity<String> postMethodName(@RequestBody Orders newOrder) {
		
		//fetching customer from customer service for the given cust id
		CustomerResponse customerResponse = customerService.getCustomer(newOrder.getCustomerId());
		
		if((customerResponse.getErrorMsg()!=null) && customerResponse.getErrorMsg().contains("Customer Not found")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerResponse.getErrorMsg());
		}
		else if((customerResponse.getErrorMsg()!=null) && customerResponse.getErrorMsg().contains("Customer Service Temporarily Unavailable"))
		{
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Customer Service Temporarily Unavailable. Please try later.");
		}
		orderService.createOrder(newOrder);
		return ResponseEntity.ok("Order Placed for customer: "+customerResponse.getCustomer().getName());
	}


}