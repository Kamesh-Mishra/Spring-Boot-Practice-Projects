package com.prf.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.prf.demo.dto.ProductDto;
import com.prf.demo.entities.ProductEntity;
import com.prf.demo.exception.ResourceNotFoundException;
import com.prf.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;
	
    private final ModelMapper modelMapper;
    
    public List<ProductDto> getAllProducts(){
    	return productRepository.findAll().stream()
    			.map(productEntity -> modelMapper.map(productEntity, ProductDto.class))
    			.collect(Collectors.toList());
    }
    
    public ProductDto createNewProduct(ProductDto input) {
    	ProductEntity productEntity = modelMapper.map(input, ProductEntity.class);
    	
    	ProductEntity savedProductEntity = productRepository.save(productEntity);
    	return modelMapper.map(savedProductEntity, ProductDto.class);
    }
    
    public ProductDto getProductById(Long id) {
    	ProductEntity productEntity = productRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " +id));
    	
    	return modelMapper.map(productEntity, ProductDto.class);
    }
    
    public ProductDto updateProduct(Long id, ProductDto input) {
        ProductEntity olderProductEntity = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+id));

        input.setId(id);
        modelMapper.map(input,olderProductEntity);
        ProductEntity savedProductEntity = productRepository.save(olderProductEntity);

        return modelMapper.map(savedProductEntity,ProductDto.class);

    }
    
    
    
    
	
}
