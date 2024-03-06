package com.fee.pay;

import java.math.BigDecimal;

public abstract class AbstractPayItem implements PayItem {

    private BigDecimal money;

    private PayType payType;

    private PayGroup payGroup;

    public AbstractPayItem(BigDecimal money, PayType payType, PayGroup payGroup) {
        this.money = money;
        this.payType = payType;
        this.payGroup = payGroup;
    }

    @Override
    public BigDecimal getMoney() {
        return this.money;
    }

    @Override
    public PayGroup getPayGroup() {
        return this.payGroup;
    }

    @Override
    public PayType getPayType() {
        return this.payType;
    }
}
