package com.application.Controller;

 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
