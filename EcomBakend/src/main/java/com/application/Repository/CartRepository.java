package com.application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Entities.Cart;
import com.application.Entities.Customer;
 

public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart> findAllByCustomerOrderByCreatedDateDesc(Customer customer);
}
