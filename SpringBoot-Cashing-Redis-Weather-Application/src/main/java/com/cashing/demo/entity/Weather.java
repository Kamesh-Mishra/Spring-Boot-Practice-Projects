package com.cashing.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="weatcher_cashe_inmemory")
public class Weather {

	 	@Id
	    @GeneratedValue
	    private Long id;

	    private String city;

	    private String forecast;
}
