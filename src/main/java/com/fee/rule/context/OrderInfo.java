package com.fee.rule.context;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfo {

    //车牌号
    private String carNo;

    //停车时长
    private Integer parkTimes;

    private Long userId;

    private BigDecimal totalMoney;

    //其他  购买 sku 信息


}
