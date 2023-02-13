package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
