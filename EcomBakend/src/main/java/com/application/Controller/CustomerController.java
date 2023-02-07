package com.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.DTO.CustomerDto;
import com.application.Entities.Customer;
import com.application.Service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {
    
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		
		Customer registeredCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(registeredCustomer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email ){
		
		Customer registeredCustomer = customerService.getCustomerDetialsByEmail(email);
		
		return new ResponseEntity<Customer>(registeredCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		
		List<Customer> registeredCustomers = customerService.getAllCustomers();
		
		return new ResponseEntity<List<Customer>>(registeredCustomers, HttpStatus.OK);
	}
	
	@PutMapping("/{email}")
   public ResponseEntity<Customer> updateCustomerByEmailHandler(@PathVariable("email") String email ,@RequestBody CustomerDto customerDto ){
		
		Customer updatedCustomer = customerService.updateCustomer(email, customerDto);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<Customer> updatePasswordHandler(@PathVariable("email") String email ,@RequestBody String password ){
		
		Customer updatedCustomer = customerService.updatePassword(email, password);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Customer> deleteUserHandler(@PathVariable("email") String email ){
		
		Customer deletedUser = customerService.deleteCustomer(email);
		
		return new ResponseEntity<Customer>(deletedUser, HttpStatus.OK);
	}
	
	
	
}
