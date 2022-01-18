package com.aeon.project.services.impl;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.repositories.CategoryMenuRepository;
import com.aeon.project.services.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCategoryMenu(Long id, CategoryMenu cmUpdate) {
        Optional<CategoryMenu> cmData = categoryRepository.findById(id);

        if (cmData.isPresent()) {
            CategoryMenu cm = cmData.get();
            cm.setCATE_LGROUP_CODE(cmUpdate.getCATE_LGROUP_CODE());
            cm.setCATE_LGROUP_NAME(cmUpdate.getCATE_LGROUP_NAME());
            cm.setCATE_MGROUP_CODE(cmUpdate.getCATE_MGROUP_CODE());
            cm.setCATE_MGROUP_NAME(cmUpdate.getCATE_MGROUP_NAME());
            cm.setCATE_SGROUP_CODE(cmUpdate.getCATE_SGROUP_CODE());
            cm.setCATE_SGROUP_NAME(cmUpdate.getCATE_SGROUP_NAME());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCategoryMenu(Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
