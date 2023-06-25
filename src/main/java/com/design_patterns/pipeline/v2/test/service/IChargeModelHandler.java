package com.design_patterns.pipeline.v2.test.service;

import com.design_patterns.pipeline.v2.test.pojo.ChargeModel;
import org.springframework.plugin.core.Plugin;
import org.springframework.stereotype.Component;

@Component
public interface IChargeModelHandler extends Plugin<ChargeModel> {

    void handleChargeModel(ChargeModel chargeModel);

}
