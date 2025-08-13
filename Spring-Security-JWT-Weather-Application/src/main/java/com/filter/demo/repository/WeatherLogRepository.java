package com.filter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filter.demo.entity.WeatherLog;

public interface WeatherLogRepository extends JpaRepository<WeatherLog, Long> {
}
