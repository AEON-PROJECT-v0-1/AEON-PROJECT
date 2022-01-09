package com.aeon.project.repositories;

import com.aeon.project.entities.CategoryProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepository extends BaseRepository<CategoryProduct, Long>  {
}
