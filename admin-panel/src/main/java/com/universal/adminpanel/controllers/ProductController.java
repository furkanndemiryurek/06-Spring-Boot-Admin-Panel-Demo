package com.universal.adminpanel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.universal.adminpanel.dto.ProductDto;
import com.universal.adminpanel.entities.Category;
import com.universal.adminpanel.entities.Product;
import com.universal.adminpanel.services.abstracts.CategoryService;
import com.universal.adminpanel.services.abstracts.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {


	ProductService productService;
	CategoryService categoryService;

	@Autowired
	public ProductController(ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping
	public ModelAndView findAllProducts() {
		ModelAndView mav = new ModelAndView("products/list-products");
		List<Product> products = productService.findAll();
		mav.addObject("products", products);
		List<Category> categories = categoryService.findAll();
		mav.addObject("categories",categories);
		return mav;
	}

	@GetMapping("/productList/{productId}")
	public String prductInfo(@PathVariable("productId") Long id, Model model) {
		Product tempProduct = productService.findProductById(id);
		model.addAttribute(tempProduct);

		return "products/product-detail.html";
	}

	@GetMapping("/newProduct")
	public String newProduct(Model model) {
		ProductDto product = new ProductDto();
		model.addAttribute("product", product);
		return "products/new-product.html";
	}

	@GetMapping("/{productId}")
	public Product findProductById(@PathVariable("productId") Long productId) {
		return productService.findProductById(productId);
	}

	@PostMapping("/save")
	public String addProduct(@ModelAttribute ProductDto product) {
		System.out.println(product.getBrand());
		productService.addProduct(product);
		return "redirect:/products";
	}

	@GetMapping("/delete/{productId}")
	public String deleteProductById(@PathVariable("productId") Long productId) {
		productService.deleteProductById(productId);
		return "redirect:/products";
	}

	@GetMapping("/updateProduct/{productId}")
	public String updateProductById(@PathVariable("productId") Long productId, Model model) {
		Product tempProduct = productService.findProductById(productId);
		ProductDto product = new ProductDto();
		product.setId(tempProduct.getId());
		product.setBrand(tempProduct.getBrand());
		product.setCategoryId(tempProduct.getCategory().getId());
		product.setColor(tempProduct.getProductDetail().getColor());
		product.setHeigth(tempProduct.getProductDetail().getHeigth());
		product.setWidth(tempProduct.getProductDetail().getWidth());
		product.setModel(tempProduct.getModel());
		product.setPrice(tempProduct.getPrice());
		product.setStock(tempProduct.getUnitsInStock());
		model.addAttribute("product", product);
		return "products/new-product.html";
	}

}
