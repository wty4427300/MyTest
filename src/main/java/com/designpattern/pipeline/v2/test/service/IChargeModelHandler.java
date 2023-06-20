package com.designpattern.pipeline.v2.test.service;

import com.designpattern.pipeline.v2.test.pojo.ChargeModel;
import org.springframework.plugin.core.Plugin;

public interface IChargeModelHandler extends Plugin<ChargeModel> {

    void handleChargeModel(ChargeModel chargeModel);

}