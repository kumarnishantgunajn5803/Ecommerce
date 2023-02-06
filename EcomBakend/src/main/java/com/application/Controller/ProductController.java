package com.application.Controller;
 

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.DTO.ProductDto;
 
import com.application.Exception.CategoryException;
import com.application.Exception.ProductException;
import com.application.Service.ProductService;

 

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 
	
	@PostMapping("/add")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) throws ProductException, CategoryException   {
		 	 
		ProductDto savedProduct = productService.createProduct(productDto);
		return new ResponseEntity<ProductDto>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> viewProductByProductId(@PathVariable("productId") Integer productId) throws ProductException{

		ProductDto productDto = productService.getProductById(productId);

		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);

	}
	
	@GetMapping("/name/{productName}")
	public ResponseEntity<ProductDto> viewProductByProductName(@PathVariable("productName") String productName) throws ProductException{
		
		ProductDto productDto = productService.getProductByName(productName);
		
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
		
	}
	@GetMapping("/allProducts")
	public ResponseEntity<List<ProductDto>> viewAllProducts() throws ProductException {

		List<ProductDto > productDtos = productService.getAllProducts();

		return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);

	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateCategory(@Valid @PathVariable("productId") Integer productId , @RequestBody ProductDto productDto) throws ProductException, CategoryException{

		 ProductDto updatedProductDto = productService.updateProduct(productDto, productId);

		return new ResponseEntity<ProductDto>(updatedProductDto, HttpStatus.OK);

	}
	
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable("productId") Integer productId) throws ProductException{

		ProductDto productDto = productService.deleteProduct(productId);

		return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);

	}
	
	
	

}
