package com.scheduling.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduling.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByStatus(String status);
}
