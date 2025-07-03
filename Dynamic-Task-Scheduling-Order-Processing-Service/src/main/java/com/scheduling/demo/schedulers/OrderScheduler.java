package com.scheduling.demo.schedulers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduling.demo.entity.Order;
import com.scheduling.demo.repository.OrderRepository;

@Service
public class OrderScheduler {
    
	@Autowired
    OrderRepository orderRepository;

//	@Scheduled(fixedRate = 1000)
    public void processPendingOrders() {
        System.out.println("Processing Orders");
        List<Order> orders = orderRepository.findByStatus("PENDING");
        orders.forEach(order -> {
            order.setStatus("COMPLETED");
            System.out.println(order.getCustomerEmail());
            orderRepository.save(order);
        });
        System.out.println("Processed pending orders "+ orders.size());
    }
}