package com.application.DTO;

public class OrderProductQuantity {
   private Integer productId;
   private Integer productQuantity;
public OrderProductQuantity() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getProductId() {
	return productId;
}

public void setProductId(Integer productId) {
	this.productId = productId;
}

public Integer getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(Integer productQuantity) {
	this.productQuantity = productQuantity;
}

public OrderProductQuantity(Integer productId, Integer productQuantity) {
	super();
	this.productId = productId;
	this.productQuantity = productQuantity;
}
   
   
}
