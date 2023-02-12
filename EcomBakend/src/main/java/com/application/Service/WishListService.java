package com.application.Service;

import java.util.List;

import com.application.DTO.ProductDto;
import com.application.Entities.Product;
import com.application.Entities.WishList;
import com.application.Exception.ProductException;
import com.application.Exception.WishListException;

public interface WishListService {
	
  public void addProductToWishList(Integer productId) throws WishListException , ProductException;
  
  public List<ProductDto> showWishList() throws WishListException;
  
  public void deleteProductFromWishList(Integer productId)throws WishListException, ProductException;
  
}
