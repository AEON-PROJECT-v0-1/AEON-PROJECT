package com.aeon.project.services.impl;

import com.aeon.project.entities.CategoryMenu;
import com.aeon.project.entities.Product;
import com.aeon.project.repositories.ProductRepository;
import com.aeon.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean updateProduct(Long id, Product pUpdate) {
        Optional<Product> pData = productRepository.findById(id);

        if (pData.isPresent()) {
            Product p = pData.get();
            p.setPRODUCT_NO(pUpdate.getPRODUCT_NO());
            p.setPRODUCT_NAME(pUpdate.getPRODUCT_NAME());
            p.setCATE_LGROUP_CODE(pUpdate.getCATE_LGROUP_CODE());
            p.setCATE_MGROUP_CODE(pUpdate.getCATE_MGROUP_CODE());
            p.setCATE_SGROUP_CODE(pUpdate.getCATE_SGROUP_CODE());
            p.setSTART_DATE(pUpdate.getSTART_DATE());
            p.setEND_DATE(pUpdate.getEND_DATE());
            p.setSALE_PRICE(pUpdate.getSALE_PRICE());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
