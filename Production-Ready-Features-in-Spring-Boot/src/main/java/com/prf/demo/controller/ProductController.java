package com.prf.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prf.demo.dto.ProductDto;
import com.prf.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto input){
        return productService.createNewProduct(input);
    }
    
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody ProductDto input){
        return productService.updateProduct(id,input);

    }


}
