package com.design_patterns.pipeline.v2.test.pojo;

import com.design_patterns.pipeline.v2.BizEnum;
import com.design_patterns.pipeline.v2.context.AbstractEventContext;
import com.design_patterns.pipeline.v2.selector.FilterSelector;
import lombok.Getter;
import lombok.Setter;


public class ChargeContext extends AbstractEventContext {

    @Setter
    @Getter
    private ChargeRequest chargeRequest;

    @Setter
    @Getter
    private Car car;

    @Setter
    @Getter
    private ChargeModel chargeModel;

    public ChargeContext(BizEnum bizEnum,
                         FilterSelector selector) {
        super(bizEnum, selector);
    }

    @Override
    public boolean continueChain() {
        return true;
    }
}
