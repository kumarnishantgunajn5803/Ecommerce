package com.application.Service;

import java.util.List;

import com.application.Entities.Product;
import com.application.Entities.WishList;
import com.application.Exception.ProductException;
import com.application.Exception.WishListException;

public interface WishListService {
	
  public void addProductToWishList(Product product) throws WishListException , ProductException;
  
  public List<WishList> showWishList() throws WishListException;
  
  public void deleteProductFromWishList(Integer productId)throws WishListException, ProductException;
  
}
