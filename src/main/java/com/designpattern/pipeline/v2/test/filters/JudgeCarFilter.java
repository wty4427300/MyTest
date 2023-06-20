package com.designpattern.pipeline.v2.test.filters;

import com.designpattern.pipeline.v2.AbstractEventFilter;
import com.designpattern.pipeline.v2.test.pojo.Car;
import com.designpattern.pipeline.v2.test.pojo.ChargeContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JudgeCarFilter extends AbstractEventFilter<ChargeContext> {

  @Override
  protected void handle(ChargeContext context) {
    Car car = context.getCar();
    log.info("carNO:{}",car.getCarNo());
  }
}
