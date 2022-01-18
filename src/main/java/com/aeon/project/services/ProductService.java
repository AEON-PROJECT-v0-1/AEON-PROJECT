package com.aeon.project.services;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.entities.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    boolean updateProduct(Long id, Product pUpdate);
    boolean deleteProduct(Long id);
}
