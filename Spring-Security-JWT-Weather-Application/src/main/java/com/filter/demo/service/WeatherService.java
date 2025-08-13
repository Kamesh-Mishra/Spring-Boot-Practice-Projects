package com.filter.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.filter.demo.entity.Weather;
import com.filter.demo.repository.WeatherRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WeatherService {

	private final WeatherRepository weatherRepository;

    public String getWeatherByCity(String city) {
        System.out.println("Fetching data from DB for city: " + city);
        Optional<Weather> weather = weatherRepository.findByCity(city);
        return weather.map(Weather::getForecast).orElse("Weather data not available");
    }
    
    
    public String updateWeather(String city, String updatedWeather) {
        weatherRepository.findByCity(city).ifPresent(weather -> {
            weather.setForecast(updatedWeather);
            weatherRepository.save(weather);
        });
        return updatedWeather;
    }
    
    @Transactional
    public void deleteWeather(String city) {
        System.out.println("Removing weather data for city: " + city);
        weatherRepository.deleteByCity(city);
    }
}
