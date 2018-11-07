package com.qingbo.sell.service;

import com.qingbo.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/29 22:13
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;
    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = service.findUpAll();
        Assert.assertNotNull(upAll);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findOne() {
        ProductInfo one = service.findOne("123321");
        System.out.println(one.getProductName());
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {

    }
}