package com.aeon.project.controllers;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.entities.Product;
import com.aeon.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Insert Product successfully", HttpStatus.OK);
    }
}
