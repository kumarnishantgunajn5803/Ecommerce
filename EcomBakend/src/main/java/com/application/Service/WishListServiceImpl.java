package com.application.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Config.JwtTokenValidatorFilter;
import com.application.DTO.ProductDto;
import com.application.Entities.Customer;
import com.application.Entities.Product;
import com.application.Entities.WishList;
import com.application.Exception.ProductException;
import com.application.Exception.WishListException;
import com.application.Repository.CustomerRepository;
import com.application.Repository.ProductRepository;
import com.application.Repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService{
	@Autowired
	private WishListRepository wishListRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	 
	
 
	
	 

	@Override
	public void addProductToWishList(Integer productId) throws WishListException, ProductException {
		 String username = JwtTokenValidatorFilter.currentUser;
	
		 
		 Customer customer = customerRepository.findByEmail(username).get();
	
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product with id :"+productId+" doesn't exist!"));

	 List<WishList> existingwishList = wishListRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
        for(WishList w:existingwishList) {
        	if(w.getProduct().getProductId()==productId) {
        		 throw new WishListException("Product has already been added to your Wishlist");        	}
        }
	      

		 
	 
	 
	
	   WishList wishList = new WishList(customer, product);
	   wishListRepository.save(wishList);
	
	}

	@Override
	public List<ProductDto> showWishList() throws WishListException {
		
        String username = JwtTokenValidatorFilter.currentUser;
		 
		 Customer customer = customerRepository.findByEmail(username).get(); 
		 
		 List<WishList> wishList = wishListRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
		 if(wishList.size()==0)throw new WishListException("No Products to show");
		 List<ProductDto> productDtos = new ArrayList<>();
		 ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		 for(WishList w: wishList) {
			 productDtos.add(productServiceImpl.convertToProductDto(w.getProduct()));
		 }
		 
		return productDtos;
	}

	@Override
	public void deleteProductFromWishList(Integer productId) throws WishListException, ProductException {
     String username = JwtTokenValidatorFilter.currentUser;
	
		 
		 Customer customer = customerRepository.findByEmail(username).get();
  List<WishList> existingwishList = wishListRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
  WishList wishList=null ;
		  for(WishList w:existingwishList) {
		  	if(w.getProduct().getProductId()==productId) {
		  		wishList=w;
		  		     }
		  } 
	if(wishList==null) {
		throw new WishListException("product doesn't exist in your wishlist");
	}
	 
		wishListRepository.delete(wishList);
	}

}
