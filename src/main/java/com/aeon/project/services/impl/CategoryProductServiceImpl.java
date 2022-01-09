package com.aeon.project.services.impl;

import com.aeon.project.entities.CategoryProduct;
import com.aeon.project.repositories.CategoryProductRepository;
import com.aeon.project.services.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

    @Autowired
    private CategoryProductRepository categoryProductRepository;

    @Override
    public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {
        return categoryProductRepository.saveAndFlush(categoryProduct);
    }

    @Override
    public List<CategoryProduct> getAllProductCategories() {
        return categoryProductRepository.findAll();
    }
}
