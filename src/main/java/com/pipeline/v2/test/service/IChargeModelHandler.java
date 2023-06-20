package com.pipeline.v2.test.service;

import com.pipeline.v2.test.pojo.ChargeModel;
import org.springframework.plugin.core.Plugin;

public interface IChargeModelHandler extends Plugin<ChargeModel> {

    void handleChargeModel(ChargeModel chargeModel);

}
