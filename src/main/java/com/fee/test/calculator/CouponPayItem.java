package com.fee.test.calculator;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CouponPayItem extends AbstractPayItem {

  public CouponPayItem(BigDecimal money) {
    super(money, PayType.WECHAT, PayGroup.THIRD_PAY);
  }

  private String couponCode;

  private String source;
}
