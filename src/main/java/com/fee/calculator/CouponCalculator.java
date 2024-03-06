package com.fee.calculator;

import com.fee.AbstractCalculator;
import com.fee.FeeCalculate;
import com.fee.FeeItemType;
import com.fee.pay.PayItem;
import com.fee.test.CalculateType;
import com.fee.test.OrderInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CouponCalculator extends AbstractCalculator<OrderInfo> {

  public CouponCalculator(FeeCalculate<OrderInfo> feeCalculate) {
    super(feeCalculate, CalculateType.COUPON);
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
    map.put(FeeItemType.SERVICE_FEE, new BigDecimal("5"));
    System.out.println("劵抵扣了5元费用");
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType, List<PayItem>> map = Maps.newHashMap();
    List<PayItem> payItems = Lists.newArrayList();
    CouponPayItem cp = new CouponPayItem(new BigDecimal(5));
    cp.setCouponCode("C1234528");
    payItems.add(cp);
    map.put(FeeItemType.SERVICE_FEE, payItems);
    return map;
  }
}
