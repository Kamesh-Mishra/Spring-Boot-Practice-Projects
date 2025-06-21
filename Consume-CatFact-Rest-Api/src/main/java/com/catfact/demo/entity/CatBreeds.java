package com.catfact.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatBreeds {

	private String breed;
	private String country;
	private String origin;
	private String coat;
	private String pattern;
	
}
