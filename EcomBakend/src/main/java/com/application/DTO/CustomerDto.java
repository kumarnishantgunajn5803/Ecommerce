package com.application.DTO;

 
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
public class CustomerDto {
      
	@NotNull(message = "User's firstName can not be null")
	@NotBlank(message = "User's firstName can not be blank")
	private String firstName;
	
	@NotNull(message = "User's lastName can not be null")
	@NotBlank(message = "User's lastName can not be blank")
	private String lastName;
	  
	
	@NotNull(message = "User's Address can not be null")
	@NotBlank(message = "User's Address can not be blank")
	private String address;
	
	@NotNull(message = "User's Role can not be null")
	@NotBlank(message = "User's Role can not be blank")
	private String role;

}
