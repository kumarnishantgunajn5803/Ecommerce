package com.application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.DTO.CustomerDto;
import com.application.Entities.Customer;
import com.application.Exception.CustomerException;
import com.application.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerRepository  customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
        Optional<Customer> existingOpt =   customerRepository.findByEmail(customer.getEmail());
        if(existingOpt!=null) {
        	throw new CustomerException("Email already exists!!");
        	 
        }
        customer.setRole("ROLE_"+customer.getRole().toUpperCase());
         customer.setPassword(passwordEncoder.encode(customer.getPassword()));   
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerDetialsByEmail(String email) throws CustomerException {
	   Customer customer = customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("User with the email :"+email+" doesn't exists!!"));
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List<Customer> customers= customerRepository.findAll();
		if(customers.size()==0) {
			throw new CustomerException("No users to show!");
		}
		return customers;
	}

	@Override
	public Customer updateCustomer(String email, CustomerDto customerDto) throws CustomerException {
		Customer existingCustomer = customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("User with the email :"+email+" doesn't exists!!"));
	     
		existingCustomer.setFirstName(customerDto.getFirstName());
		existingCustomer.setLastName(customerDto.getLastName());
		existingCustomer.setAddress(customerDto.getAddress());
		existingCustomer.setRole("ROLE_"+customerDto.getRole().toUpperCase());
		
		return customerRepository.save(existingCustomer);
	}

	@Override
	public Customer deleteCustomer(String email) throws CustomerException {
		   Customer customer = customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("User with the email :"+email+" doesn't exists!!"));
		  customerRepository.delete(customer);
		   return customer;
	}

	@Override
	public Customer updatePassword(String email ,String password) throws CustomerException {
	Customer customer = customerRepository.findByEmail(email).orElseThrow(()-> new CustomerException("User with the email :"+email+" doesn't exists!!"));
	customer.setPassword(passwordEncoder.encode(customer.getPassword()));  
	   
		return customerRepository.save(customer);
	}

}
