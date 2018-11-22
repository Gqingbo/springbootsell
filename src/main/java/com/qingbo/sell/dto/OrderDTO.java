package com.qingbo.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qingbo.sell.dataobject.OrderDetail;
import com.qingbo.sell.enums.EOrderStatus;
import com.qingbo.sell.enums.EPayStatus;
import com.qingbo.sell.utils.EnumUtil;
import com.qingbo.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;


    private List<OrderDetail> orderDetails;

    @JsonIgnore
    public EOrderStatus getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, EOrderStatus.class);
    }

    @JsonIgnore
    public EPayStatus getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, EPayStatus.class);
    }
}
