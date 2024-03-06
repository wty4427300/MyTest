package com.fee.calculator;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
public class ActivityPayItem extends AbstractPayItem {

  public ActivityPayItem(BigDecimal money) {
    super(money, PayType.ACTIVITY, PayGroup.COUPON);
  }

  private String activityName;
}
