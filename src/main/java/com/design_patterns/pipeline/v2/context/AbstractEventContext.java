package com.design_patterns.pipeline.v2.context;


import com.design_patterns.pipeline.v2.selector.FilterSelector;
import com.design_patterns.pipeline.v2.BizEnum;

/**
 * 抽象上下文类
 */
public abstract class AbstractEventContext implements EventContext {

    private final BizEnum bizEnum;
    private final FilterSelector selector;

    public AbstractEventContext(BizEnum bizEnum, FilterSelector selector) {
        this.bizEnum = bizEnum;
        this.selector = selector;
    }

    @Override
    public BizEnum getBizCode() {
        return bizEnum;
    }

    @Override
    public FilterSelector getFilterSelector() {
        return selector;
    }
}
