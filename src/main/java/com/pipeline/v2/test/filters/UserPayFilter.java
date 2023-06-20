package com.pipeline.v2.test.filters;


import com.pipeline.v2.AbstractEventFilter;
import com.pipeline.v2.test.pojo.ChargeContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserPayFilter extends AbstractEventFilter<ChargeContext> {
    @Override
    protected void handle(ChargeContext context) {
        Long id = context.getChargeModel().getUser().getId();
        log.info("支付判断逻辑");
    }
}
