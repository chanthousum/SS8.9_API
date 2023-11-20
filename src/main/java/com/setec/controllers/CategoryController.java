package com.setec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setec.models.Category;
import com.setec.services.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("/")
	public List<Category> getCategoryList(){
		return categoryService.getCategoryList();
	}
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Category category){
		return categoryService.save(category);
	}
	@GetMapping("/findById/{id}")
	public Category findById(@PathVariable int id) {
		return categoryService.findById(id);
	}
	
	@PostMapping("/findByName")
	public List<Category> findByName(@RequestBody Category category){
		return categoryService.findCategoryByName(category);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateById(@PathVariable int id,@RequestBody Category category){
		return categoryService.updateById(id,category);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return categoryService.deleteById(id);
	}
	
	
}
