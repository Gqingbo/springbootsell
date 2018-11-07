package com.qingbo.sell.dao;

import com.qingbo.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/30 23:08
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private static final String OPENID="11023203404";
    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest request = new PageRequest(0,2);

        Page<OrderMaster> byBuyerOpenid = (Page<OrderMaster>) repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotNull(byBuyerOpenid);
    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12343453");
        orderMaster.setBuyerOpenid("234567432456dffd");
        orderMaster.setBuyerName("测试购买");
        orderMaster.setBuyerAddress("这里的山路十八弯");
        orderMaster.setBuyerPhone("110119120");
        orderMaster.setOrderAmount(new BigDecimal(43.43));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }
}