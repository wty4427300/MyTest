package com.fee.rule.factory;

import com.fee.base.FeeCalculate;
import com.fee.rule.FeeRule;
import com.fee.rule.FeeRuleType;
import com.fee.rule.FreeTimeRule;
import com.fee.rule.FreeTimesRule;
import com.fee.rule.calculator.FreeTimeCalculator;
import com.fee.rule.calculator.FreeTimesCalculator;
import com.fee.rule.calculator.MaxLimitCalculator;
import com.fee.rule.calculator.PlusRuleCalculator;
import com.fee.rule.context.OrderInfo;

import java.util.Objects;


public class CalculatorFactory {

  public static FeeCalculate<OrderInfo> getFeeCalculateByRuleType(FeeCalculate<OrderInfo> calculate, FeeRule rule) {
    if (Objects.equals(FeeRuleType.FREE_TIME, rule.getRuleType())) {
      FreeTimeRule time = (FreeTimeRule) rule;//这里可以强制转化
      return new FreeTimeCalculator(calculate, CalculatorType.FREE_TIME, time.getConfigValue().intValue());
    } else if (Objects.equals(FeeRuleType.FREE_TIMES, rule.getRuleType())) {
      FreeTimesRule timesRule = (FreeTimesRule) rule;
      return new FreeTimesCalculator(calculate, CalculatorType.FREE_TIMES, timesRule.getConfigValue().intValue());
    } else if (Objects.equals(FeeRuleType.PLUS_RULE, rule.getRuleType())) {
      //不需要可以不转
      return new PlusRuleCalculator(calculate, CalculatorType.PLUS_DISCOUNT, rule.getConfigValue());
    } else if (Objects.equals(FeeRuleType.MAX_LIMIT, rule.getRuleType())) {
      return new MaxLimitCalculator(calculate, CalculatorType.MAX_LIMIT, rule.getConfigValue());
    }
    return null;
  }


}
