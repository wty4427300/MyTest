package com.fee.test;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfo {
    /**
     * 订单唯一编号
     */
    private String tradeFlowNo;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 服务费
     */
    private BigDecimal serviceFee;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
}
