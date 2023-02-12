package com.application.Entities;

import java.util.Date;
 

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	
	@OneToOne
	private Customer customer;
	
	
	private Date createdDate;
	
	@ManyToOne
	@Column(unique = true)
	private Product product;
	

}
