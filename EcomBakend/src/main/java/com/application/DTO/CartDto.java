package com.application.DTO;

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
public class CartDto {
	
	
  private Integer cartId;
  @Min(value = 1,message = "ProductId can not be less than 1.")
  private Integer productId;
  @Min(value = 1,message = "Product quantity can not be less than 1.")
  private Integer quantity;
}
