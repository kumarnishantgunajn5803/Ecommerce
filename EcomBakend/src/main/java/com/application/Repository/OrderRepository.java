package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Entities.OrderDetail;

public interface OrderRepository  extends JpaRepository<OrderDetail, Integer>{
	

}
