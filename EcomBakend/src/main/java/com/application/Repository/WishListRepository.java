package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Entities.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer>{

}
