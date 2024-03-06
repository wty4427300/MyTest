package com.fee.test;

import com.fee.base.AbstractFeeItem;
import com.fee.base.FeeItemType;

import java.math.BigDecimal;

public class OverWeightFeeItem extends AbstractFeeItem<OrderInfo> {

  public OverWeightFeeItem(OrderInfo orderInfo, FeeItemType itemType,
                           BigDecimal itemMoney) {
    super(orderInfo, itemType, itemMoney);
  }
}
