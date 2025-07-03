package com.scheduling.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "`order`")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerEmail;
    private String status; // PENDING, PROCESSING, COMPLETED
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }
}
