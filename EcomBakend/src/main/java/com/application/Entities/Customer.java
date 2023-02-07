package com.application.Entities;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

 
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull(message = "User's firstName can not be null")
	@NotBlank(message = "User's firstName can not be blank")
	private String firstName;
	
	@NotNull(message = "User's lastName can not be null")
	@NotBlank(message = "User's lastName can not be blank")
	private String lastName;
	
	@NotNull(message = "User's Email can not be null")
	@NotBlank(message = "User's Email can not be blank")
	@Column(unique = true)
	private String email;
	
	@NotNull(message = "User's Password can not be null")
	@NotBlank(message = "User's Password can not be blank")
	@JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotNull(message = "User's Address can not be null")
	@NotBlank(message = "User's Address can not be blank")
	private String address;
	
	@NotNull(message = "User's Role can not be null")
	@NotBlank(message = "User's Role can not be blank")
	private String role;

}
