package com.application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Entities.Customer;
import com.application.Entities.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer>{
	List<WishList> findAllByCustomerOrderByCreatedDateDesc(Customer customer);

}
