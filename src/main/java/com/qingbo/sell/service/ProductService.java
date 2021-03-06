package com.qingbo.sell.service;


import com.qingbo.sell.dataobject.ProductInfo;
import com.qingbo.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    ProductInfo findOne(String productId);

    @Transactional
    void increaseStock(List<CartDTO> cartDTOList);

    @Transactional
    void decreaseStock(List<CartDTO> cartDTOList);
}
