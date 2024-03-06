package com.fee.rule.payitem;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;

import java.math.BigDecimal;

public class FreeTimesPayItem extends AbstractPayItem {

  public FreeTimesPayItem(BigDecimal money, PayType payType,
      PayGroup payGroup) {
    super(money, payType, payGroup);
  }
}
