package com.design_patterns.pipeline.v2.test.filters;

import com.design_patterns.pipeline.v2.filter.AbstractEventFilter;
import com.design_patterns.pipeline.v2.test.pojo.Car;
import com.design_patterns.pipeline.v2.test.pojo.ChargeContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JudgeCarFilter extends AbstractEventFilter<ChargeContext> {

  @Override
  protected void handle(ChargeContext context) {
    Car car = context.getCar();
    log.info("carNO:{}",car.getCarNo());
  }
}
