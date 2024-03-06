package com.fee.test;

import com.fee.base.BaseEnum;
import com.fee.base.Unique;

import java.util.Optional;


public enum CalculateType implements BaseEnum<CalculateType>, Unique {

  COUPON(1, "优惠劵计算器"),
  ACTIVITY(2,"活动计算器");

  CalculateType(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<CalculateType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(CalculateType.class, code));
  }

  @Override
  public Integer getUniqueCode() {
    return this.code;
  }
}
