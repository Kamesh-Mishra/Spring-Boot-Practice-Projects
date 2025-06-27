package com.catfact.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.catfact.demo.entity.Cat;

@Service
public class CatService {
	 
	public String getPublicAPI() {
	        String url = "https://catfact.ninja/fact";
	        
//			using RestTemplate	        
//	        RestTemplate restTemplate = new RestTemplate();
//	        Cat obj = restTemplate.getForObject(url, Cat.class);
//	        return obj.getFact();
	        
//			using WebClient
	        WebClient.Builder builder = WebClient.builder();
	        Cat catFact = builder.build().get().uri(url).retrieve().bodyToMono(Cat.class).block();
	        return catFact.getFact();

	     	}
	
	
}
