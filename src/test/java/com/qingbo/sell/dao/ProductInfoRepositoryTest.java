package com.qingbo.sell.dao;

import com.qingbo.sell.dataobject.ProductInfo;
import com.qingbo.sell.enums.EProductStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/29 22:04
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123321");
        productInfo.setProductName("粥宫一号");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductStatus(EProductStatus.UP.getCode());
        productInfo.setProductDescription("好好好好好好好好好好好好好啊啊");
        productInfo.setProductIcon("http://dfgfsdgfdsfg.jpg");
        productInfo.setCategoryType(2);
        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
    }

}