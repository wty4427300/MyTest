package com.fee.calculator;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/6 8:42 下午
 */
@Setter
@Getter
public class CouponPayItem extends AbstractPayItem {

  public CouponPayItem(BigDecimal money) {
    super(money, PayType.COIN, PayGroup.COUPON);
  }

  private String couponCode;

  private String source;
}
