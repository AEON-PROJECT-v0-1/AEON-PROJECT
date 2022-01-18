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

    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product pUpdate){
        boolean updateResult = productService.updateProduct(id, pUpdate);
        if(updateResult)
            return new ResponseEntity<>("Update Product Successfully with id : " + id, HttpStatus.OK);
        else
            return new ResponseEntity<>("Product not found with id : " + id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id){
        boolean updateResult = productService.deleteProduct(id);
        if(updateResult)
            return new ResponseEntity<>("Delete Product successfully with id : " + id,HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Delete Product failed with id : " + id,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
