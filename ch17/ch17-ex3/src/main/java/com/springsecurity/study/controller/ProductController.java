package com.springsecurity.study.controller;

import com.springsecurity.study.model.Product;
import com.springsecurity.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    public List<Product> findProducts() {
        return productService.findProducts();
    }
}
