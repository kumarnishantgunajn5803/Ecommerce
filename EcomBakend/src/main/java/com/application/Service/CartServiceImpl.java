package com.application.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Config.JwtTokenValidatorFilter;
import com.application.DTO.CartDto;
import com.application.DTO.CartItemDto;
import com.application.DTO.ProductDto;
import com.application.Entities.Cart;
import com.application.Entities.Customer;
import com.application.Entities.Product;
 
import com.application.Exception.CartException;
import com.application.Exception.ProductException;
import com.application.Repository.CartRepository;
import com.application.Repository.CustomerRepository;
import com.application.Repository.ProductRepository;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	

	@Override
	public void addToCart(CartDto cartDto) throws ProductException, CartException {
           String username = JwtTokenValidatorFilter.currentUser;
	
		 
		 Customer customer = customerRepository.findByEmail(username).get();
		 System.out.println("productId"+cartDto.getProductId() );
		 System.out.println("quantity"+cartDto.getQuantity());
		 int productId = cartDto.getProductId();
	
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductException("Product with id :"+productId+" doesn't exist!"));
		 List<Cart> existingcartList = cartRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
		 for(Cart c: existingcartList) {
			if(c.getProduct().getProductId()==productId) { 
				throw  new CartException("Product already Exists in your cart");
			}
		 }
		 Cart cart = new Cart();
		 cart.setProduct(product);
		 cart.setCustomer(customer);
		 cart.setCreatedDate(new Date());
		 cart.setQuantity(cartDto.getQuantity());
		 
	  cartRepository.save(cart);
		
		
	}

	@Override
	public List<CartItemDto> getListOfCartItem() throws CartException {
		  String username = JwtTokenValidatorFilter.currentUser;
			
			 
			Customer customer = customerRepository.findByEmail(username).get();
			 
		
 	 List<Cart> existingcartList = cartRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
 	 List<CartItemDto> cartItemDtos = new ArrayList<>();
 	 for(Cart c:existingcartList) {
 		CartItemDto cartItemDto = new CartItemDto();
 		cartItemDto.setCartId(c.getCartId());
 		cartItemDto.setProductDto(convertToProductDto(c.getProduct()));
 		cartItemDto.setQuantity(c.getQuantity());
 		cartItemDtos.add(cartItemDto);
 	 }
 	 return cartItemDtos;
	}

	@Override
	public void deleteCartItem(Integer cartId) throws CartException {
		  String username = JwtTokenValidatorFilter.currentUser;
			
			 
			Customer customer = customerRepository.findByEmail(username).get();
			 
		
	 List<Cart> existingcartList = cartRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
	Cart deleteCart =null;
	 for(Cart c:existingcartList) {
		 if(c.getCartId()==cartId) {
			 deleteCart=c;
		 }
	 }
	   cartRepository.delete(deleteCart);
	 
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

	@Override
	public CartItemDto updateCart( Integer cartId , Integer quantity) throws CartException {
		Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new CartException("cart doesn't exists")); 
		cart.setQuantity(quantity);
		
	  Cart c =	cartRepository.save(cart);
	  
	  CartItemDto cartItemDto = new CartItemDto();
		cartItemDto.setCartId(c.getCartId());
		cartItemDto.setProductDto(convertToProductDto(c.getProduct()));
		cartItemDto.setQuantity(c.getQuantity());
		 
		
		return cartItemDto;
	}

}
