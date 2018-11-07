package com.qingbo.sell.service.impl;

import com.qingbo.sell.dao.ProductInfoRepository;
import com.qingbo.sell.dataobject.ProductInfo;
import com.qingbo.sell.dto.CartDTO;
import com.qingbo.sell.enums.EProductStatus;
import com.qingbo.sell.enums.ResultEnum;
import com.qingbo.sell.exception.OrderException;
import com.qingbo.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductInfoRepository productInfoRepository;

    @Autowired
    public ProductServiceImpl(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(EProductStatus.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO dto :cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findById(dto.getProductId()).get();
            if (productInfo.getProductId()==null){
                throw new OrderException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + dto.getProductQuantity();
            productInfo.setProductStock(result);

            productInfoRepository.save(productInfo);
        }


    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO dto :cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findById(dto.getProductId()).get();
            if (productInfo.getProductId()==null){
                throw new OrderException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = productInfo.getProductStock() - dto.getProductQuantity();
            if (result<0){
                throw new OrderException(ResultEnum.PRODUCT_STOCK_ERR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
