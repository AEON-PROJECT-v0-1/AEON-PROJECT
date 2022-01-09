package com.aeon.project.controllers;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.services.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorymenu")
public class CategoryMenuController {
    @Autowired
    private CategoryMenuService category;

    @GetMapping("/getAll")
    public List<CategoryMenu> getAllCategoryMenu() {
        return category.getAllCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCategoryMenu(@RequestBody CategoryMenu categoryMenu){
        category.createCategoryMenu(categoryMenu);
        return new ResponseEntity<>("Insert Category Menu successfully", HttpStatus.OK);
    }
}
