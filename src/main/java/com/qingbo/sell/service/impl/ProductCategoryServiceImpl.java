package com.qingbo.sell.service.impl;

import com.qingbo.sell.dao.ProductCategoryRepository;
import com.qingbo.sell.dataobject.ProductCategory;
import com.qingbo.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        return list;
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return productCategoryRepository.save(category);
    }
}
