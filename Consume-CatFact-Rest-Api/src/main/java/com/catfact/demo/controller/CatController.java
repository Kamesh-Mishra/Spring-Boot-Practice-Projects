package com.catfact.demo.controller;


import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	 
	 
}
