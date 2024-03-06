package com.fee.test;

import com.fee.base.AbstractFeeItem;
import com.fee.base.FeeItemType;

import java.math.BigDecimal;

public class ServiceFeeItem extends AbstractFeeItem<OrderInfo> {

    public ServiceFeeItem(OrderInfo orderInfo, FeeItemType itemType,
                          BigDecimal itemMoney) {
        super(orderInfo, itemType, itemMoney);
    }
}
