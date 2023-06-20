package com.designpattern.pipeline.v2.test.filters;


import com.designpattern.pipeline.v2.AbstractEventFilter;
import com.designpattern.pipeline.v2.test.pojo.ChargeContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserPayFilter extends AbstractEventFilter<ChargeContext> {

    @Override
    protected void handle(ChargeContext context) {
        log.info("支付判断逻辑");
    }
}
