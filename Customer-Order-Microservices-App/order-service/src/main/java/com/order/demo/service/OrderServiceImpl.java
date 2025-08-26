package com.order.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.demo.entity.Orders;
import com.order.demo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepository;
	
	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Orders createOrder(Orders neworder) {
		return orderRepository.save(neworder);
	}

}
