package com.setec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setec.exceptions.StudentNotfFoundException;
import com.setec.models.Product;
import com.setec.repositorys.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getProductList() {
		List<Product> productList=productRepository.findAll();
		List<Product> productList1=new ArrayList<>();
		for(int i=0;i<productList.size();i++) {
			Product product=new Product();
			product.setName(productList.get(i).getName());
			product.setBarcode(productList.get(i).getBarcode());		
			productList1.add(product);
		}
		return productList1;
	}

	public ResponseEntity<Object> save(Product product) {
		Product product1 = new Product();
		product1.setName(product.getName());
		product1.setBarcode(product.getBarcode());
		product1.setUnitPrice(product.getUnitPrice());
		product1.setCategory(product.getCategory());
		product1.setCreateBy(product.getCreateBy());
		
		Product product2=productRepository.findByName(product.getName());
		if(product2!=null) {
			throw new StudentNotfFoundException("Product Name has been alreday");
		}
		Product product3=productRepository.findByBarcode(product.getBarcode());
		if(product3!=null) {
			throw new StudentNotfFoundException("Barcode has been alreday");
		}
		productRepository.save(product1);
		return new ResponseEntity<Object>("Product Create", HttpStatus.CREATED);
	}

	public Product findById(int id) {
		Product product=productRepository.findProductById(id);		
		if(product==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		Product product1=new Product();
		product1.setName(product.getName());
		product1.setBarcode(product.getBarcode());
		return product1;
	}

	public List<Product> findProductByName(Product Product) {
		List<Product> productList=productRepository.findProductByName(Product.getName());
		if(productList.size()==0) {
			throw new StudentNotfFoundException("Search not found");
		}
		
		List<Product> productList1=new ArrayList<>();
		for(int i=0;i<productList.size();i++) {
			Product product=new Product();
			product.setName(productList.get(i).getName());
			product.setBarcode(productList.get(i).getBarcode());		
			productList1.add(product);
		}
		return productList1;
	}

	public ResponseEntity<Object> updateById(int id, Product product) {
		Product product1=productRepository.findProductById(id);
		if(product1==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		product1.setName(product.getName());
		product1.setUpdateBy(product.getUpdateBy());
		productRepository.save(product1);
		return new ResponseEntity<Object>("Product Updated",HttpStatus.OK);
	}

	public ResponseEntity<Object> deleteById(int id) {
		Product product1=productRepository.findProductById(id);
		if(product1==null) {
			throw new StudentNotfFoundException("Not found id :"+id);
		}
		productRepository.deleteById(product1.getId());
		return new ResponseEntity<Object>("Product Deleted",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
