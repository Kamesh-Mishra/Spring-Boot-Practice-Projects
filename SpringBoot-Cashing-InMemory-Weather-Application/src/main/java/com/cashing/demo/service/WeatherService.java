package com.cashing.demo.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cashing.demo.entity.Weather;
import com.cashing.demo.repository.WeatherRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WeatherService {

	private final WeatherRepository weatherRepository;
	
	@Cacheable(value = "weather", key = "#city")
	public String getWeatherByCity(String city) {
        System.out.println("Fetching data from DB for city: " + city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return weather.map(Weather::getForecast).orElse("Weather data not available");
    }
	
	@CachePut(value = "weather",key = "#city")
	public String updateWeather(String city, String updatedWeather) {
        weatherRepository.findByCity(city).ifPresent(weather -> {
            weather.setForecast(updatedWeather);
            weatherRepository.save(weather);
        });
        return updatedWeather;
    }
	
	@CacheEvict(value = "weather",key = "#city")
	@Transactional
	public void deleteWeather(String city) {
	        System.out.println("Removing weather data for city: " + city);
	        weatherRepository.deleteByCity(city);
	}
}
