package com.aeon.project.services;

import com.aeon.project.entities.CategoryMenu;

import java.util.List;

public interface CategoryMenuService {
    CategoryMenu createCategoryMenu(CategoryMenu categoryMenu);
    List<CategoryMenu> getAllCategories();
    boolean updateCategoryMenu(Long id, CategoryMenu cmUpdate);
    boolean deleteCategoryMenu(Long id);
}
