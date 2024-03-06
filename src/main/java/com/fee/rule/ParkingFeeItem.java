package com.fee.rule;


import com.fee.base.FeeItem;
import com.fee.base.FeeItemType;
import com.fee.rule.context.OrderInfo;

import java.math.BigDecimal;

public class ParkingFeeItem implements FeeItem<OrderInfo> {

  private final OrderInfo orderInfo;

  public ParkingFeeItem(OrderInfo orderInfo) {
    this.orderInfo = orderInfo;
  }

  @Override
  public BigDecimal getFeeItemOriginMoney() {
    return orderInfo.getTotalMoney();
  }

  @Override
  public FeeItemType getFeeItemType() {
    return FeeItemType.SERVICE_FEE;
  }

  @Override
  public OrderInfo getOrderInfo() {
    return orderInfo;
  }
}
