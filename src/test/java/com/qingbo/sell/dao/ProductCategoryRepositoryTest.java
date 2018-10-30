package com.qingbo.sell.dao;

import com.qingbo.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/29 15:42
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findAll();
        for (ProductCategory p : byCategoryTypeIn) {
            System.out.println(p.getCategoryId() + "--" + p.getCategoryName() + "--" + p.getCategoryType());
        }
    }
    @Test
    @Transactional//当不希望测试数据保存时，加上此注解可以每次执行完后自动回滚
    public void saveTest(){
        ProductCategory category = new ProductCategory();
        category.setCategoryName("吃香喝辣");
        category.setCategoryType(3);
        productCategoryRepository.save(category);
    }
}