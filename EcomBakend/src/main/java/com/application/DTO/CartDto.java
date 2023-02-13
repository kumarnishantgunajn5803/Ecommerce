package com.application.DTO;

 
public class CartDto {
	
	
  private Integer cartId;
  
  private Integer productId;
  
  private Integer quantity;

public Integer getCartId() {
	return cartId;
}

public void setCartId(Integer cartId) {
	this.cartId = cartId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public CartDto(Integer cartId, int productId, int quantity) {
	super();
	this.cartId = cartId;
	this.productId = productId;
	this.quantity = quantity;
}

public CartDto() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "CartDto [cartId=" + cartId + ", productId=" + productId + ", quantity=" + quantity + "]";
}
  
  
}
