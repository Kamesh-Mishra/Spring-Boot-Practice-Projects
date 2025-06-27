package com.postalpincode.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.postalpincode.demo.output.PostOfficeResponse;
import com.postalpincode.demo.service.IPostService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/postal")
public class PostDetailsController {

	IPostService postalServiceImpl;
	
	@GetMapping(value="/byCity")
	public PostOfficeResponse  getPostalbyCity(@RequestParam String city) {
		PostOfficeResponse postOfficeResponse = postalServiceImpl.fetchPostOfficeDetailsByCity(city);
		return postOfficeResponse;
	}
}
