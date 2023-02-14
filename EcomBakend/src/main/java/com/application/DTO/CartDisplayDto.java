package com.application.DTO;

import java.util.List;



public class CartDisplayDto {
	  private List<CartItemDto> cartItems;
	    private double totalCost;
	    
	    
		public CartDisplayDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public List<CartItemDto> getCartItems() {
			return cartItems;
		}
		public void setCartItems(List<CartItemDto> cartItems) {
			this.cartItems = cartItems;
		}
		public double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		public CartDisplayDto(List<CartItemDto> cartItems, double totalCost) {
			super();
			this.cartItems = cartItems;
			this.totalCost = totalCost;
		}
		@Override
		public String toString() {
			return "CartDisplayDto [cartItems=" + cartItems + ", totalCost=" + totalCost + "]";
		}
	    
	    

}
