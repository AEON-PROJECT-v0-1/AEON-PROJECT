package com.aeon.project.services;

import com.aeon.project.entities.CategoryProduct;

import java.util.List;

public interface CategoryProductService {
    CategoryProduct createCategoryProduct(CategoryProduct categoryProduct);
    List<CategoryProduct> getAllProductCategories();
    boolean updateCategoryProduct(Long id, CategoryProduct cmUpdate);
    boolean deleteCategoryProduct(Long id);
}
