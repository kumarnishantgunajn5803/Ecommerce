package com.application.Entities;

 

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
