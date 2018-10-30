package com.qingbo.sell.service;

import com.qingbo.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/29 21:53
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {
    @Autowired
    private ProductCategoryService service;

    @Test
    public void findByCategoryTypeIn() {

    }

    @Test
    public void findOne() {
        ProductCategory one = service.findOne(1);
        Assert.assertEquals(new Integer(1),one.getCategoryId());
    }

    @Test
    public void findAll() {

    }

    @Test
    public void save() {
    }
}