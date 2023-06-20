package com.designpattern.pipeline.v2.test.filters;

import com.designpattern.pipeline.v2.AbstractEventFilter;
import com.designpattern.pipeline.v2.test.pojo.Car;
import com.designpattern.pipeline.v2.test.pojo.ChargeContext;
import com.designpattern.pipeline.v2.test.pojo.ChargeModel;
import com.designpattern.pipeline.v2.test.pojo.ChargeRequest;
import com.designpattern.pipeline.v2.test.service.IFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class CarInfoQueryFilter extends AbstractEventFilter<ChargeContext> {

  //filter 里面 查询缓存，使用消息 ，调用其他服务
  private final IFacadeService facadeService;

  @Override
  protected void handle(ChargeContext context) {
    if(Objects.isNull(context.getCar())){
      ChargeRequest chargeRequest = context.getChargeRequest();
      String carNo = chargeRequest.getCarNo();
      Car car = facadeService.getCarInfoByCarNO(carNo);
      context.setCar(car);
      ChargeModel chargeModel = new ChargeModel();
      context.setChargeModel(chargeModel);
    }
    log.info("查询车辆信息并且放入上下文中");

  }
}
