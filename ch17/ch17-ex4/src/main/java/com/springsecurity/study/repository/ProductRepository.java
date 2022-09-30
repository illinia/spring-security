package com.springsecurity.study.repository;

import com.springsecurity.study.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @PostFilter("filterObject.owner == authentication.name")
//    List<Product> findProductByNameContains(String text);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:text% AND p.owner=?#{authentication.name}")
    List<Product> findProductByNameContains(String text);
}
