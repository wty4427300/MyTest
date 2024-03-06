package com.fee.test;

import com.fee.AbstractFeeItem;
import com.fee.FeeItemType;

import java.math.BigDecimal;

public class ServiceFeeItem extends AbstractFeeItem<OrderInfo> {

    public ServiceFeeItem(OrderInfo orderInfo, FeeItemType itemType,
                          BigDecimal itemMoney) {
        super(orderInfo, itemType, itemMoney);
    }
}
