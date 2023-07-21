package com.universal.adminpanel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universal.adminpanel.entities.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long>{

}
