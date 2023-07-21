package com.universal.adminpanel.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto {
	Long id;
	
	String brand;
	
	String model;
	
	double price;
	
	int stock;
	
	String color;
	
	double heigth;
	
	double width;
	
	Long categoryId;

	public ProductDto(String brand, String model, double price, int stock, String color, double height, double width,
			Long categoryId) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.stock = stock;
		this.color = color;
		this.heigth = height;
		this.width = width;
		this.categoryId = categoryId;
	}
	
	
	
}
