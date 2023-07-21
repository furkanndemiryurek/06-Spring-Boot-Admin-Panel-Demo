package com.universal.adminpanel.services.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal.adminpanel.dao.CategoryDAO;
import com.universal.adminpanel.dao.ProductDAO;
import com.universal.adminpanel.dto.ProductDto;
import com.universal.adminpanel.entities.Category;
import com.universal.adminpanel.entities.Product;
import com.universal.adminpanel.entities.ProductDetail;
import com.universal.adminpanel.services.abstracts.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


	ProductDAO productDao;
	CategoryDAO categoryDao;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDao, CategoryDAO categoryDao) {
		super();
		this.productDao = productDao;
		this.categoryDao = categoryDao;
	}
	
	@Override
	public void addProduct(ProductDto product) {
		Product tempProduct = new Product();
		if(product.getId() != null) {
			tempProduct = productDao.findById(product.getId()).get();
		}
		tempProduct.setBrand(product.getBrand());
		tempProduct.setModel(product.getModel());
		tempProduct.setPrice(product.getPrice());
		tempProduct.setUnitsInStock(product.getStock());
		ProductDetail tempProductDetail = new ProductDetail();
		tempProduct.setProductDetail(tempProductDetail);
		tempProduct.getProductDetail().setColor(product.getColor());
		tempProduct.getProductDetail().setHeigth(product.getHeigth());
		tempProduct.getProductDetail().setWidth(product.getWidth());
		Category tempCategory = categoryDao.findById(product.getCategoryId()).get();
		tempProduct.setCategory(tempCategory);
		productDao.save(tempProduct);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findProductById(long productId) {
		Optional<Product> product = productDao.findById(productId);
		if(product.isPresent()) {
			return productDao.findById(productId).get();
		}else {
			return null;	
		}
	}

	@Override
	public String deleteProductById(long productId) {
		Optional<Product> product = productDao.findById(productId);
		if(product.isPresent()) {
			productDao.deleteById(productId);
			return "Ürün silindi";
		}else {
			return "Ürün bulunamadı";
		}
	}
}
