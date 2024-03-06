package com.fee.base;

import java.math.BigDecimal;

public class AbstractFeeItem<O> implements FeeItem<O> {

    /**
     * 订单
     */
    private final O orderInfo;

    /**
     * 费用项类型
     */
    private final FeeItemType itemType;

    /**
     * 结算金额
     */
    private final BigDecimal itemMoney;

    public AbstractFeeItem(O orderInfo, FeeItemType itemType, BigDecimal itemMoney) {
        this.orderInfo = orderInfo;
        this.itemType = itemType;
        this.itemMoney = itemMoney;
    }

    @Override
    public BigDecimal getFeeItemOriginMoney() {
        return itemMoney;
    }

    @Override
    public FeeItemType getFeeItemType() {
        return itemType;
    }

    @Override
    public O getOrderInfo() {
        return orderInfo;
    }
}
