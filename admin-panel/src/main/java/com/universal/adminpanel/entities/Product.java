package com.universal.adminpanel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String brand;
	
	private String model;
	
	private double price;
	
	@Column(name = "units_in_stock")
	private int unitsInStock;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
						,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_detail_id")
	@JsonIgnore
	private ProductDetail productDetail;

	
}
