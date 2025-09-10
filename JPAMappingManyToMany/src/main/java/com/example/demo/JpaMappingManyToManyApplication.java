package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;

@SpringBootApplication
public class JpaMappingManyToManyApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaMappingManyToManyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
//		Product product1 = new Product();
//		product1.setpId("pid1");
//		product1.setProductName("iphone 15 pro max");
//		
//		
//		Product product2 = new Product();
//		product2.setpId("pid2");
//		product2.setProductName("samsung s22 ultra");
//		
//		Product product3 = new Product();
//		product3.setpId("pid3");
//		product3.setProductName("samsung tv");
//		
//		Category category1 = new Category();
//		category1.setcId("cid1");
//		category1.setTitle("Electronics");
//		
//
//		Category category2 = new Category();
//		category2.setcId("cid2");
//		category2.setTitle("Mobile Phone");
//		
//
//
//		List<Product> category1products = category1.getProducts();
//		category1products.add(product1);
//		category1products.add(product2);
//		category1products.add(product3);
//		
//		List<Product> category2products  =category2.getProducts();
//		category2products.add(product1);
//		category2products.add(product2);
		
//		
////		product1.setCategories(List.of(category1, category2));
////		
////		product2.setCategories(List.of(category1, category2));
////		
////		product3.setCategories(List.of(category1));
//		

		
		
//		categoryRepo.save(category1);
//		categoryRepo.save(category2);
		
//		
////		productRepo.save(product1);
////		productRepo.save(product2);
////		productRepo.save(product3);
//		
		
//		 Category categoryy = categoryRepo.findById("cid1").get();
//		 System.out.println(categoryy.getProducts().size());
//		 
//		 Category categoryy2 = categoryRepo.findById("cid2").get();
//		 System.out.println(categoryy2.getProducts().size());
//		 
//		 Product productt = productRepo.findById("pid1").get();
//		 productt.getCategories().forEach(c -> System.out.println(c.getTitle()));		 
//		
		
		
		
	}

}
