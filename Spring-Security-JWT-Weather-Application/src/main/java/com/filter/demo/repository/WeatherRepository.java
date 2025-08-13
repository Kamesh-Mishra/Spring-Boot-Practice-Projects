package com.filter.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filter.demo.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findByCity(String city);
    
    void deleteByCity(String city);
    
    
}