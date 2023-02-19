package com.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

import com.application.Common.ApiResponse;
import com.application.DTO.OrderInputDto;
import com.application.Service.OrderDetailService;

 
@RestController
@RequestMapping("/placeOrder")
public class OrderController {
      
	@Autowired
	private OrderDetailService orderDetailService;
	
	@PostMapping("/")
	public ResponseEntity<ApiResponse> addProductToWishListHandler(@RequestBody OrderInputDto orderInputDto){
	  
	     orderDetailService.placeOrder(orderInputDto);
	 ApiResponse apiResponse= new ApiResponse(true, "Order has been Placed Successfully.");
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
	}
}
