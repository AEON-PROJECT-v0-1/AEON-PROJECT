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

    @PostMapping("/update")
    public ResponseEntity<?> updateCategoryMenu(@PathVariable("id") long id, @RequestBody CategoryMenu categoryMenu){
        boolean updateResult = category.updateCategoryMenu(id, categoryMenu);
        if(updateResult)
            return new ResponseEntity<>("Update Category Menu Successfully with id : " + id, HttpStatus.OK);
        else
            return new ResponseEntity<>("Category Menu not found with id : " + id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryMenu(@PathVariable("id") long id){
        boolean updateResult = category.deleteCategoryMenu(id);
        if(updateResult)
            return new ResponseEntity<>("Delete category menu successfully with id : " + id,HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Delete category menu failed with id : " + id,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
