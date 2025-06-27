package com.postalpincode.demo.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostOfficeDetails {

	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("BranchType")
	private String branchType;
	
	@JsonProperty("DeliveryStatus")
	private String deliveryStatus;
	
	@JsonProperty("Circle")
	private String circle;
	
	@JsonProperty("District")
	private String district;
	
	@JsonProperty("Division")
	private String division;
	
	@JsonProperty("Region")
	private String region;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Pincode")
	private String pincode;
	
	
	
}
