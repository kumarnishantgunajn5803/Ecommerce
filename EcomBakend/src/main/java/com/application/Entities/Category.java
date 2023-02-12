package com.application.Entities;
 
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
public class Category {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int categoryId;
  
  @NotNull(message = "Category's Name can not be null")
  @NotBlank(message = "Category's Name can not be blank")
  @Column(unique = true)
  private String categoryName;
  
  @NotNull(message = "Description can not be null")
  @NotBlank(message = "Category's Description can not be blank")
  private String categoryDescription;
  
  @NotNull(message = "Image Url can not be null")
  @NotBlank(message = "Image Url can not be blank")
  private String imageUrl;
  
  @JsonIgnore
  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
  Set<Product> products;
  
}
