package com.application.Entities;

import java.util.Date;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class OrderDetail {
	
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer orderId;
	
	 
   private String userFullName;
   private Date createdDate;
   private String address;
   private String contactNumber;
   private String alternateContactNumber;
   private String orderStatus;
   private double orderAmount;
   
   @OneToOne
   private Product product;
    
   @OneToOne
   private Customer customer;
   
   
   
}
