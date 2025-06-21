package com.catfact.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.catfact.demo.entity.Cat;
import com.catfact.demo.entity.CatBreeds;

@Service
public class CatService {
	 
	public String getPublicAPI() {
	        String url = "https://catfact.ninja/fact";
	        RestTemplate restTemplate = new RestTemplate();
	        Cat obj = restTemplate.getForObject(url, Cat.class);
	        return obj.getFact();
	     	    }
	
	
	
	public List<CatBreeds> getCatHBreedAPI() {
        String url = "https://catfact.ninja/breeds?limit=1000";
        RestTemplate restTemplate = new RestTemplate();
//        List<CatBreeds> obj = restTemplate.getForObject(url, List.class);
//        return obj;
        
	    ResponseEntity<CatBreeds[]> response = restTemplate.getForEntity(url,CatBreeds[].class);
	//	ResponseEntity<Invoice[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Invoice[].class);
	    CatBreeds[] breeds = response.getBody();
		List<CatBreeds> list = Arrays.asList(breeds);

		return (list);
        
     	    }
}
