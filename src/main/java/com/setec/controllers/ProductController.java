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

import com.setec.models.Product;
import com.setec.services.ProductService;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
	@Autowired
	ProductService ProductService;
	@GetMapping("/")
	public List<Product> getProductList(){
		return ProductService.getProductList();
	}
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Product product){
		return ProductService.save(product);
	}
	@GetMapping("/findById/{id}")
	public Product findById(@PathVariable int id) {
		return ProductService.findById(id);
	}
	
	@PostMapping("/findByName")
	public List<Product> findByName(@RequestBody Product product){
		return ProductService.findProductByName(product);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateById(@PathVariable int id,@RequestBody Product product){
		return ProductService.updateById(id,product);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return ProductService.deleteById(id);
	}
	
	
}
