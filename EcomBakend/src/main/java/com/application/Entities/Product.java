package com.application.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Product {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@NotNull(message = "Product's Name can not be null")
	@NotBlank(message = "Product's Name can not be blank")
	@Column(unique = true)
	private String productName;
	
	@NotNull(message = "Product Description can not be null")
	@NotBlank(message = "Product's Description can not be blank")
	private String productDescription;
	
	@Min(value = 0,message = "Product Price can not be less than 0.")
	 
	private double productPrice;
	
	@NotNull(message = "Image Url can not be null")
	@NotBlank(message = "Image Url can not be blank")
    private String imageUrl;
	
	@JoinColumn(name = "category")
	@ManyToOne
	private Category category;
	
}
