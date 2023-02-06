package com.application.DTO;

import javax.persistence.Column;
 
  
 
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
 
public class ProductDto {
	 
	private Integer productId;
	
	@NotNull(message = "Product's Name can not be null")
	@NotBlank(message = "Product's Name can not be blank")
	@Column(unique = true)
	private String productName;
	
	@NotNull(message = "Product Description can not be null")
	@NotBlank(message = "Product's Description can not be blank")
	private String productDescription;
	
	 
	 
	private double productPrice;
	
	@NotNull(message = "Image Url can not be null")
	@NotBlank(message = "Image Url can not be blank")
    private String imageUrl;
	
	@NotNull(message = "Category Id can not be null")
	@NotBlank(message = "Category Id can not be blank")
	 
	private Integer categoryId;
	
}
