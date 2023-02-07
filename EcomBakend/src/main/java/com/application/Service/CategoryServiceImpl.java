package com.application.Service;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Entities.Category;
import com.application.Exception.CategoryException;
import com.application.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public Category createCategory(Category category) throws CategoryException {
		Category existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(existingCategory!=null)throw new CategoryException("Category with this name already Exist");
		 
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Integer id) throws CategoryException {
	    Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryException("Category with id :"+id+" doesn't Exist"));
		return category;
	}

	@Override
	public Category getCategoryByName(String name) throws CategoryException {
		Category existingCategory = categoryRepository.findByCategoryName(name);
		if(existingCategory == null)throw new CategoryException("Category with this name doesn't Exist");
		return existingCategory;
	}

	@Override
	public List<Category> getAllCategories() throws CategoryException {
		List<Category> categories = categoryRepository.findAll();
		if(categories.size()==0)throw new CategoryException("No Category Available");
		return categories;
	}

	@Override
	public Category deleteCategory(Integer id) throws CategoryException {
		 Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryException("Category with id :"+id+"doesn't Exist"));
		 categoryRepository.delete(category);

		 return category;	
	}

	@Override
	public Category updateCategory(Integer id, Category newCategory) throws CategoryException {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryException("Category with id :"+id+"doesn't Exist"));
		category.setCategoryName(newCategory.getCategoryName());
		category.setCategoryDescription(newCategory.getCategoryDescription());
		category.setImageUrl(newCategory.getImageUrl());
		categoryRepository.save(category);
		
		return category;
	}

}
