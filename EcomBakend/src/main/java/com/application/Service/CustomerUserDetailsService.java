package com.application.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.application.Entities.Customer;
import com.application.Repository.CustomerRepository;

public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
   private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> optCustomer = customerRepository.findByEmail(username);
		if(optCustomer.isPresent()) {
			Customer customer = optCustomer.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			return new User(customer.getEmail(), customer.getPassword(), authorities);
			
			
		}else throw new BadCredentialsException("Invlaid crendtials!");
		 
	}

}
