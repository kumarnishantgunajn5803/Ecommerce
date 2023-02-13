package com.application.Entities;

 

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	    @JsonIgnore
	    @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "category_id", nullable = false)
	    Category category;

	    @JsonIgnore
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product"  )
	    private List<WishList> wishListList;
	    
	    
	    @JsonIgnore
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product"  )
	    private List<Cart> carts;

}
