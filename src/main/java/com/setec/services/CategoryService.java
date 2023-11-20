package com.setec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setec.exceptions.StudentNotfFoundException;
import com.setec.models.Category;
import com.setec.repositorys.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	public ResponseEntity<Object> save(Category category) {
		Category category1 = new Category();
		category1.setName(category.getName());
		category1.setCreateBy(category.getCreateBy());
		Category category2=categoryRepository.findByName(category.getName());
		if(category2!=null) {
			throw new StudentNotfFoundException("Category Name has been alreday");
		}
		categoryRepository.save(category1);
		return new ResponseEntity<Object>("Category Create", HttpStatus.CREATED);
	}

	public Category findById(int id) {
		Category category=new Category();
		category=categoryRepository.findCategoryById(id);
		if(category==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		return category;
	}

	public List<Category> findCategoryByName(Category category) {
		List<Category> categoryList=categoryRepository.findCategoryByName(category.getName());
		return categoryList;
	}

	public ResponseEntity<Object> updateById(int id, Category category) {
		Category category1=categoryRepository.findCategoryById(id);
		if(category1==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		category1.setName(category.getName());
		category1.setUpdateBy(category.getUpdateBy());
		categoryRepository.save(category1);
		return new ResponseEntity<Object>("Category Updated",HttpStatus.OK);
	}

	public ResponseEntity<Object> deleteById(int id) {
		Category category1=categoryRepository.findCategoryById(id);
		if(category1==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		categoryRepository.deleteById(category1.getId());
		return new ResponseEntity<Object>("Category Deleted",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
