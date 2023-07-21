package com.universal.adminpanel.services.abstracts;

import java.util.List;

import com.universal.adminpanel.dto.ProductDto;
import com.universal.adminpanel.entities.Product;

public interface ProductService {
	void addProduct(ProductDto product);
	
	List<Product> findAll();
	
	Product findProductById(long productId);
	
	String deleteProductById(long productId);
}
