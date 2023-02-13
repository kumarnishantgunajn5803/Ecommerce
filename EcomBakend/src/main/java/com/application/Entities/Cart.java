package com.application.Entities;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
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
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer cartId;
   
   private Date createdDate;
   
   @ManyToOne( )
   @JoinColumn(name = "product_id", referencedColumnName = "productId")
   private Product product;
   
   @JsonIgnore
   @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;
   
   @Min(value = 0,message = "Product quantity can not be less than 0.")
   private Integer quantity;
   
   
}
