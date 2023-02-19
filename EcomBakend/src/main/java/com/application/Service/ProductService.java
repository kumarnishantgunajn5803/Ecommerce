package com.application.Service;

import java.util.List;

import com.application.DTO.ProductDto;
import com.application.Entities.Category;
import com.application.Exception.CategoryException;
import com.application.Exception.ProductException;

public interface ProductService {
	
    public ProductDto createProduct(ProductDto product)throws ProductException,CategoryException ;
    
    public ProductDto getProductById(Integer productId)throws ProductException;
    
    public ProductDto getProductByName(String productName)throws ProductException;
    
    public List<ProductDto> getAllProducts()throws ProductException;
    
    public ProductDto updateProduct(ProductDto productDto , Integer productId)throws ProductException,CategoryException;
    
    public ProductDto deleteProduct(Integer id)throws ProductException;
    
  
    
}
