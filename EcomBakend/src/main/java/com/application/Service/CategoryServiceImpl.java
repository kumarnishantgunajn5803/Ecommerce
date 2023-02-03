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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(Integer id) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByName(String name) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategories() throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category deleteCategory(Integer id) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Integer id, Category newCategory) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
