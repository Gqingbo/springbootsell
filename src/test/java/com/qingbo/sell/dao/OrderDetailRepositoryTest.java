package com.qingbo.sell.dao;

import com.qingbo.sell.dataobject.OrderDetail;
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
 * @Date: 2018/10/30 23:23
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;


    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,byOrderId.size());
    }
}