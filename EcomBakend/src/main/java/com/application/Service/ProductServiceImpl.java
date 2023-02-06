package com.application.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DTO.ProductDto;
import com.application.Entities.Category;
import com.application.Entities.Product;
import com.application.Exception.CategoryException;
import com.application.Exception.ProductException;
import com.application.Repository.CategoryRepository;
import com.application.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ProductDto createProduct(ProductDto product) throws ProductException,CategoryException{
		Product existingProduct = productRepository.findByProductName(product.getProductName());
		Optional<Category> optCategory = categoryRepository.findById(product.getCategoryId()) ;
	    if(!optCategory.isPresent()) {
	    	throw new CategoryException("Category Doesn't Exist with id :"+product.getCategoryId());
	    }
	    Category category = optCategory.get();
 		if(existingProduct!=null)throw new ProductException("Product with same name already exist!");
		Product savedProduct = new Product(); 
		savedProduct.setProductName(product.getProductName());
		savedProduct.setProductDescription(product.getProductDescription());
		savedProduct.setImageUrl(product.getImageUrl());
		savedProduct.setProductPrice(product.getProductPrice());
		savedProduct.setCategory(category);
		
	Product product2=	productRepository.save(savedProduct);
	product.setProductId(product2.getProductId());
		return product;
	}

	@Override
	public ProductDto getProductById(Integer productId) throws ProductException {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product with id :"+productId+" doesn't exist!"));
		 return convertToProductDto(product);
	}

	@Override
	public ProductDto getProductByName(String productName) throws ProductException {
		Product product = productRepository.findByProductName(productName);
		if(product==null)throw  new ProductException("Product with name :"+productName+" doesn't exist!");
		 return convertToProductDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() throws ProductException {
		List<Product> products = productRepository.findAll();
		if(products.isEmpty())throw new ProductException("No Products to show !");
		List<ProductDto> productDtos = new ArrayList<>();
		for(Product p:products) {
			productDtos.add(convertToProductDto(p));
		}
		 
		return productDtos;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto,Integer productId) throws ProductException, CategoryException {
		Product savedProduct = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product with id :"+productId+" doesn't exist!"));
		savedProduct.setProductName(productDto.getProductName());
		savedProduct.setProductDescription(productDto.getProductDescription());
		savedProduct.setImageUrl(productDto.getImageUrl());
		savedProduct.setProductPrice(productDto.getProductPrice());
	    Optional<Category> optCategory = categoryRepository.findById(productDto.getCategoryId()) ;
	    if(optCategory.isEmpty()) {
	    	throw new CategoryException("Category Doesn't Exist with id :"+productDto.getCategoryId());
	    }
	    Category category = optCategory.get();
		savedProduct.setCategory(category);
		productRepository.save(savedProduct);
		return convertToProductDto(savedProduct);
	}

	@Override
	public ProductDto deleteProduct(Integer productId) throws ProductException {
		Product savedProduct = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product with id :"+productId+" doesn't exist!"));
       
		productRepository.delete(savedProduct);
		return convertToProductDto(savedProduct);
	}
	
	public ProductDto convertToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProductName(product.getProductName());
		productDto.setProductDescription(product.getProductDescription());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setProductPrice(product.getProductPrice());
		productDto.setCategoryId(product.getCategory().getCategoryId());
		productDto.setProductId(product.getProductId());
		
		return productDto;
	}

}
