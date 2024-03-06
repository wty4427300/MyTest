package com.fee.calculator;

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
    super(money, PayType.COIN, PayGroup.COUPON);
  }

  private String couponCode;

  private String source;
}
