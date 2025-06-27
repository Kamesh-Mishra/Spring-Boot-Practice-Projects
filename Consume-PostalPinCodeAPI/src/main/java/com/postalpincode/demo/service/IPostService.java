package com.postalpincode.demo.service;

import com.postalpincode.demo.output.PostOfficeResponse;

public interface IPostService {

	public PostOfficeResponse fetchPostOfficeDetailsByCity(String city);
	
}
