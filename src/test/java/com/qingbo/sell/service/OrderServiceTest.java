package com.qingbo.sell.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.qingbo.sell.dataobject.OrderDetail;
import com.qingbo.sell.dto.OrderDTO;
import com.qingbo.sell.enums.EOrderStatus;
import com.qingbo.sell.enums.EPayStatus;
import com.sun.tools.corba.se.idl.PragmaEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/10/31 21:36
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceTest {
    @Autowired
    private OrderService service;
    private final String BUYER_OPENID = "1101110";

//    private final String ORDER_ID = "1497183332311989948";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张无忌");
        orderDTO.setBuyerAddress("桃花源");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123321");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("157875227953464068");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetails(orderDetailList);

        OrderDTO result = service.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO one = service.findOne("1540993861957502681");
        Assert.assertEquals("1540993861957502681",one.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = service.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }

    @Test
    @Transactional
    public void cancel() {
        OrderDTO orderDTO = service.findOne("1540993861957502681");
        OrderDTO result = service.cancel(orderDTO);
        Assert.assertEquals(EOrderStatus.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = service.findOne("1540993861957502681");
        OrderDTO result = service.finish(orderDTO);
        Assert.assertEquals(EOrderStatus.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = service.findOne("1540993861957502681");
        OrderDTO result = service.paid(orderDTO);
        Assert.assertEquals(EPayStatus.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void methodtest(){
        List<String> paramas = new ArrayList<>();
        paramas.add("bbbb");
        paramas.add("cccc");
        List<String> paramList = new ArrayList<>();
        paramList.add("aaa");
        paramList.addAll(paramas);
        String format = String.format("the1=%s,the2=%s,the3=%s", paramList.toArray());
        System.out.println(format);
    }

}