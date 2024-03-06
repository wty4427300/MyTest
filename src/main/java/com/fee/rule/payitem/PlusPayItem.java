package com.fee.rule.payitem;

import com.fee.pay.AbstractPayItem;
import com.fee.pay.PayGroup;
import com.fee.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public class PlusPayItem extends AbstractPayItem {

  @Setter
  @Getter
  private String plusNo;

  @Setter
  @Getter
  private Long userId;

  public PlusPayItem(BigDecimal money, PayType payType,
      PayGroup payGroup) {
    super(money, payType, payGroup);
  }
}
