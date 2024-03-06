package com.fee.rule;

import java.math.BigDecimal;

/**
 * 减免次数规则
 */
public class FreeTimesRule extends AbstractFeeRule{

  public FreeTimesRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    super(configValue, ruleType, order);
  }
}
