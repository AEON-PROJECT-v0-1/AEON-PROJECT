package com.aeon.project.services;

import com.aeon.project.entities.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
}
