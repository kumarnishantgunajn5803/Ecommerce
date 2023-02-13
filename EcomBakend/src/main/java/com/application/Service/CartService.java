package com.application.Service;

import java.util.List;

import com.application.DTO.CartDto;
import com.application.DTO.CartItemDto;
import com.application.Exception.CartException;
import com.application.Exception.ProductException;

public interface CartService {
	
   public void addToCart(CartDto cartDto) throws ProductException, CartException;
   
   public List<CartItemDto> getListOfCartItem()throws CartException;
   
   public void deleteCartItem(Integer cartId) throws CartException;
   
   public CartItemDto updateCart(Integer cartId , Integer quantity)throws CartException;
   
}
