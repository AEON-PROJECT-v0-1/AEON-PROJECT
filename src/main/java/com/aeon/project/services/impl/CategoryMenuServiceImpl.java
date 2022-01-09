package com.aeon.project.services.impl;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.repositories.CategoryMenuRepository;
import com.aeon.project.services.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMenuServiceImpl implements CategoryMenuService {

    @Autowired
    private CategoryMenuRepository categoryRepository;

    @Override
    public CategoryMenu createCategoryMenu(CategoryMenu categoryMenu) {
        return categoryRepository.saveAndFlush(categoryMenu);
    }

    @Override
    public List<CategoryMenu> getAllCategories() {
        return categoryRepository.findAll();
    }
}
