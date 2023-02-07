package com.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
 
import org.springframework.web.bind.annotation.RestController;

import com.application.Entities.Customer;
import com.application.Repository.CustomerRepository;

@RestController
public class SignInController {
	
   @Autowired
	private CustomerRepository customerRepository;
   
    @GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInUserDetailsHandler(Authentication auth ){
		
		Customer registeredCustomer = customerRepository.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("Invalid Credentials!"));
		
		return new ResponseEntity<Customer>(registeredCustomer, HttpStatus.OK);
	}
}
