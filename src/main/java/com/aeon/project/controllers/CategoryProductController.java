package com.aeon.project.controllers;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.entities.CategoryProduct;
import com.aeon.project.services.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoryproduct")
public class CategoryProductController {

    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/getAll")
    public List<CategoryProduct> getAllCategoryMenu() {
        return categoryProductService.getAllProductCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCategoryProduct(@RequestBody CategoryProduct categoryProduct){
        categoryProductService.createCategoryProduct(categoryProduct);
        return new ResponseEntity<>("Insert Category Menu successfully", HttpStatus.OK);
    }
}
