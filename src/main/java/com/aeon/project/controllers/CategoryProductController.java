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

    @PostMapping("/update")
    public ResponseEntity<?> updateCategoryProduct(@PathVariable("id") long id, @RequestBody CategoryProduct categoryProduct){
        boolean updateResult = categoryProductService.updateCategoryProduct(id, categoryProduct);
        if(updateResult)
            return new ResponseEntity<>("Update Category Product Successfully with id : " + id, HttpStatus.OK);
        else
            return new ResponseEntity<>("Category Product not found with id : " + id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryProduct(@PathVariable("id") long id){
        boolean updateResult = categoryProductService.deleteCategoryProduct(id);
        if(updateResult)
            return new ResponseEntity<>("Delete Category Product successfully with id : " + id,HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Delete Category Product failed with id : " + id,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
