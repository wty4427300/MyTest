package com.fee.test.calculator;

import com.fee.base.AbstractCalculator;
import com.fee.base.FeeCalculate;
import com.fee.base.FeeItemType;
import com.fee.pay.PayItem;
import com.fee.test.CalculateType;
import com.fee.test.OrderInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 服务费抵扣活动
 */
public class ActivityCalculator extends AbstractCalculator<OrderInfo> {

  public ActivityCalculator(FeeCalculate<OrderInfo> feeCalculate) {
    super(feeCalculate, CalculateType.ACTIVITY);
  }

  /**
   * 算子抵扣金额
   */
  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
                                                        OrderInfo o) {
    Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
    map.put(FeeItemType.SERVICE_FEE, new BigDecimal("4"));
    System.out.println("活动抵扣了4元费用");
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType, List<PayItem>> map = Maps.newHashMap();
    List<PayItem> payItems = Lists.newArrayList();
    ActivityPayItem ap = new ActivityPayItem(new BigDecimal(4));
    ap.setActivityName("节日活动");
    payItems.add(ap);
    map.put(FeeItemType.SERVICE_FEE, payItems);
    return map;
  }
}
