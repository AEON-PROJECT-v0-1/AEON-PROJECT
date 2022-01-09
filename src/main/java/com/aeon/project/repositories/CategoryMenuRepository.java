package com.aeon.project.repositories;

import com.aeon.project.entities.CategoryMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMenuRepository extends BaseRepository<CategoryMenu, Long> {
}
