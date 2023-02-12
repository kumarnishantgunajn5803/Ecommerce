package com.application.Entities;

import java.util.Date;
 

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class WishList {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer wishListId;
	
	
	  @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	  @JoinColumn(nullable = false, name = "customerId")
	private Customer customer;
	
	
	private Date createdDate;
	
	@ManyToOne()
    @JoinColumn(name = "productId" , unique = true)
	private Product product;
	
   public WishList(Customer customer, Product product) {
	   this.customer=customer;
	   this.product=product;
	   this.createdDate= new Date();
   }
}
