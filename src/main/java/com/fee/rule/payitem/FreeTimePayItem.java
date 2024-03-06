package com.fee.rule.payitem;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;

import java.math.BigDecimal;

public class FreeTimePayItem extends AbstractPayItem {

  public FreeTimePayItem(BigDecimal money, PayType payType,
      PayGroup payGroup) {
    super(money, payType, payGroup);
  }
}
