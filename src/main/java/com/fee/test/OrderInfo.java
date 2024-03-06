package com.fee.test;

import lombok.Data;

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

}
