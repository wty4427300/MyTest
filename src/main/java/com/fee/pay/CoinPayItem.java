package com.fee.pay;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CoinPayItem extends AbstractPayItem{

  public CoinPayItem(BigDecimal money) {
    super(money, PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
  }

  //来源
  private String source;
  

}
