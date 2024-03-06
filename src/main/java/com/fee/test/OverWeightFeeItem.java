package com.fee.test;

import com.fee.AbstractFeeItem;
import com.fee.FeeItemType;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/6 8:29 下午
 */
public class OverWeightFeeItem extends AbstractFeeItem<OrderInfo> {

  public OverWeightFeeItem(OrderInfo orderInfo, FeeItemType itemType,
                           BigDecimal itemMoney) {
    super(orderInfo, itemType, itemMoney);
  }
}
