package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_product_manytomany")
public class Product {

	@Id
	private String pId;
	
	private String productName;
	
	
	@ManyToMany(mappedBy= "products", fetch = FetchType.EAGER)
	private List<Category> categories = new ArrayList<>();


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String pId, String productName, List<Category> categories) {
		super();
		this.pId = pId;
		this.productName = productName;
		this.categories = categories;
	}


	public String getpId() {
		return pId;
	}


	public void setpId(String pId) {
		this.pId = pId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
}
