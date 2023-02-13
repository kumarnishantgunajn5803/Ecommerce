package com.application.Controller;

import java.util.List;

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

import com.application.Common.ApiResponse;
import com.application.DTO.CartDto;
import com.application.DTO.CartItemDto;
import com.application.Service.CartService;

 

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addProductToCartListHandler( @RequestBody CartDto cartDto  ){
	  
	 cartService.addToCart(cartDto);
	 ApiResponse apiResponse= new ApiResponse(true, "Product Added to cart successfully");
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CartItemDto>> getCartListHandler( ){
	  
		List<CartItemDto> cartItemDtos =    cartService.getListOfCartItem();
	 
		
		return new ResponseEntity<List<CartItemDto>>(cartItemDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<ApiResponse> deleteProductFromCartHandler(@PathVariable("cartId") Integer cartId ){
	  
		
		cartService.deleteCartItem(cartId);
 	 ApiResponse apiResponse= new ApiResponse(true, "Product Removed From Cart");
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
	
	@PutMapping("/{cartId}")
	public ResponseEntity<CartItemDto> updateCartQuantityHandler(@PathVariable("cartId") Integer cartId , @RequestBody Integer quantity ){
	  
		
		CartItemDto cartItemDto= cartService.updateCart(cartId,quantity);
 	 
		
		return new ResponseEntity<CartItemDto>(cartItemDto, HttpStatus.CREATED);
	}
	

}
