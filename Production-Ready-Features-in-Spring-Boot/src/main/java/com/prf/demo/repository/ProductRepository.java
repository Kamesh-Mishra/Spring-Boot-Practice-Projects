package com.prf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prf.demo.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	
}
