package com.application.Service;

import com.application.DTO.OrderInputDto;
import com.application.Exception.OrderException;
import com.application.Exception.ProductException;

public interface OrderDetailService {
	
   public void placeOrder(OrderInputDto orderInputDto) throws OrderException ,ProductException;
   
}
