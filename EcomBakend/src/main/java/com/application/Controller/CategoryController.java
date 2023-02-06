package com.application.Controller;

 
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RestController;

import com.application.Entities.Category;
 
import com.application.Exception.CategoryException;
import com.application.Service.CategoryService;
 
 

 
@RestController
public class CategoryController {
	@Autowired
   private CategoryService categoryService;
   
	@PostMapping("/addCategory")
   public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category)throws CategoryException{
	   Category savedCategory = categoryService.createCategory(category);
	   return new ResponseEntity<Category>(savedCategory, HttpStatus.CREATED);
   }
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Category> viewCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{

		Category category = categoryService.getCategoryById(categoryId);

		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}
	@GetMapping("/category/name/{categoryName}")
	public ResponseEntity<Category> viewCategory(@PathVariable("categoryName") String categoryName) throws CategoryException{

		Category category = categoryService.getCategoryByName(categoryName);

		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {

		List<Category > categories = categoryService.getAllCategories();

		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);

	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{

		Category deletedCategory = categoryService.deleteCategory(categoryId);

		return new ResponseEntity<Category>(deletedCategory, HttpStatus.OK);

	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Category> updateCategory(@Valid @PathVariable("categoryId") Integer categoryId , @RequestBody Category category) throws CategoryException{

		Category updatedCategory = categoryService.updateCategory(categoryId, category);

		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);

	}
	
	
}
