package com.catfact.demo.controller;


import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.catfact.demo.entity.CatBreeds;
import com.catfact.demo.service.CatService;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CatController {
	
    private CatService catService;

	 @GetMapping("/callPublicAPI")
	    private String getPublicAPI() {
	       return catService.getPublicAPI();
	    }
	 
	 
	 
	 @GetMapping("/catbreeds")
	    private List<CatBreeds> getCatBreeds() {
	       return catService.getCatHBreedAPI(); 
	    }
}
