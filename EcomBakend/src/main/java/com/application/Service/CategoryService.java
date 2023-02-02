package com.application.Service;

import java.util.List;

import com.application.Entities.Category;
import com.application.Exception.CategoryException;

public interface CategoryService {
	
    public Category createCategory(Category category)throws CategoryException ;
    
    public Category getCategoryById(Integer id)throws CategoryException ;
    
    public Category getCategoryByName(String name)throws CategoryException;
    
    public List<Category> getAllCategories()throws CategoryException;
    
    public Category deleteCategory(Integer id)throws CategoryException;
    
    public Category updateCategory(Integer id, Category newCategory)throws CategoryException;
    
    
    
}
