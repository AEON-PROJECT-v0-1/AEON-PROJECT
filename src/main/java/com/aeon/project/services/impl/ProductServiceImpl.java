package com.aeon.project.services.impl;

import com.aeon.project.entities.Product;
import com.aeon.project.repositories.ProductRepository;
import com.aeon.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
