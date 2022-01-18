package com.aeon.project.services.impl;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.entities.CategoryProduct;
import com.aeon.project.repositories.CategoryProductRepository;
import com.aeon.project.services.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCategoryProduct(Long id, CategoryProduct cpUpdate) {
        Optional<CategoryProduct> cpData = categoryProductRepository.findById(id);

        if (cpData.isPresent()) {
            CategoryProduct cp = cpData.get();
            cp.setPROGRAM_NAME(cpUpdate.getPROGRAM_NAME());
            cp.setPROGRAM_ID(cpUpdate.getPROGRAM_ID());
            cp.setINSERT_ID(cpUpdate.getINSERT_ID());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCategoryProduct(Long id) {
        try {
            categoryProductRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
