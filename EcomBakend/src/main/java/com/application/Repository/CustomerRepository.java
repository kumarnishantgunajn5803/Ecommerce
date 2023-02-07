package com.application.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	 public Optional<Customer> findByEmail(String email);
 
}
