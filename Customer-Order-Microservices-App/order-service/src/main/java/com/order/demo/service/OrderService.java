package com.order.demo.service;

import java.util.List;

import com.order.demo.entity.Orders;

public interface OrderService {
	
	  List<Orders> getAllOrders();
	  
	  Orders createOrder(Orders neworder);
	  
}
