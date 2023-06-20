package com.designpattern.pipeline.v2.test.service;

import com.designpattern.pipeline.v2.test.pojo.ChargeRequest;

public interface IChargeService {

  void handle(ChargeRequest chargeRequest);

}
