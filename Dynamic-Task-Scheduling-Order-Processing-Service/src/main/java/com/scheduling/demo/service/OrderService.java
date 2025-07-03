package com.scheduling.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduling.demo.dto.OrderRequest;
import com.scheduling.demo.entity.Order;
import com.scheduling.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerEmail(request.getCustomerEmail());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
