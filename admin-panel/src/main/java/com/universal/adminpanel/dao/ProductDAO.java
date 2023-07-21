package com.universal.adminpanel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universal.adminpanel.entities.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{

}
