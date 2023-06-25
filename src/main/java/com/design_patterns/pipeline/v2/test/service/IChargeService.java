package com.design_patterns.pipeline.v2.test.service;

import com.design_patterns.pipeline.v2.test.pojo.ChargeRequest;

public interface IChargeService {

  void handle(ChargeRequest chargeRequest);

}
