package com.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Common.ApiResponse;
import com.application.DTO.ProductDto;
import com.application.Entities.Customer;
import com.application.Repository.WishListRepository;
import com.application.Service.WishListService;

@RestController
@RequestMapping("/wishList")
public class WishListController {
  
	@Autowired
	private WishListService wishListService;
	
	@PostMapping("/{productId}")
	public ResponseEntity<ApiResponse> addProductToWishListHandler(@PathVariable("productId") Integer productId ){
	  
	 wishListService.addProductToWishList(productId);
	 ApiResponse apiResponse= new ApiResponse(true, "Product Added to wishList");
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProductOfWishListHandler(){
		List<ProductDto> dto= wishListService.showWishList();
		return new ResponseEntity<List<ProductDto>>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProductFromWishListHandler(@PathVariable("productId") Integer productId ){
	  
	 wishListService.deleteProductFromWishList(productId);
	 ApiResponse apiResponse= new ApiResponse(true, "Product Deleted From WishList");
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
}
