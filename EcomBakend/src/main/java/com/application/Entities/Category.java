package com.application.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  
  
}
