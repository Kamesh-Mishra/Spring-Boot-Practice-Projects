package com.postalpincode.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.postalpincode.demo.output.PostOfficeDetails;
import com.postalpincode.demo.output.PostOfficeResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostalServiceImpl implements IPostService {

	RestTemplate restTemplate;

	@Override
	public PostOfficeResponse fetchPostOfficeDetailsByCity(String cityValue) {
		String url = "https://api.postalpincode.in/postoffice/{city}";
		url = url.replace("{city}", cityValue);
		System.out.println("Url is :"+url);
		
		ResponseEntity<PostOfficeResponse[]> postalResponseEntity = restTemplate
					.getForEntity(url, PostOfficeResponse[].class);
		
		System.out.println("Response status code is : "+postalResponseEntity.getStatusCode());
		PostOfficeResponse[] responseBeanArray = postalResponseEntity.getBody();
		
		for(PostOfficeResponse response : responseBeanArray) {
			List<PostOfficeDetails> postOfficeList = response.getPostOffice();
			for(PostOfficeDetails po : postOfficeList)
				System.out.println(po.getName()+"***"+po.getCountry()+"***"+po.getPincode());
		}
		
		return responseBeanArray[0];
	}

}
