package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Entities.Category;
@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer>{
     public Category findByCagegoryName(String categoryName);
}
