package com.fee.rule;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class PlusRule extends AbstractFeeRule{

  @Setter
  @Getter
  private String cardNo;

  public PlusRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    super(configValue, ruleType, order);
  }
}
