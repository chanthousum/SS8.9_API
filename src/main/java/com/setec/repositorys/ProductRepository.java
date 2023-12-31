package com.setec.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setec.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	Product findProductById(int id);

	List<Product> findProductByName(String name);

	Product findByName(String name);

	Product findByBarcode(long barcode);

}
