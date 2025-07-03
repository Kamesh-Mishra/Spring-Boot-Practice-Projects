package com.cashing.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cashing.demo.entity.Weather;
import com.cashing.demo.repository.WeatherRepository;
import com.cashing.demo.service.CacheInspectionService;
import com.cashing.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final WeatherService weatherService;
	
    private final WeatherRepository weatherRepository;
    
    private final CacheInspectionService cacheInspectionService;
    
    @GetMapping("/cacheData")
    public void getCacheDate() {
        cacheInspectionService.printCacheContents("weather");
    }
    
	@GetMapping
	public String getWeather(@RequestParam String city) {
        String weatherByCity = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }
	
	 @PostMapping
	 public Weather addWeather(@RequestBody Weather weather) {
	        return weatherRepository.save(weather);
	 }
	
	 @GetMapping("/all")
	 public List<Weather> getAllWeather() {
		 return weatherRepository.findAll();
	 }
 
	 @PutMapping("/{city}")
	 public String updateWeather(@PathVariable String city, @RequestParam String weatherUpdate) {
		 return weatherService.updateWeather(city, weatherUpdate);
	 }

	 @DeleteMapping("/{city}")
	 public String deleteWeather(@PathVariable String city) {
		 weatherService.deleteWeather(city);
		 return "Weather data for " + city + " has been deleted and cache evicted.";
	 }
}
