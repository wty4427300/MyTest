package com.design_patterns.pipeline.v2;

import com.design_patterns.pipeline.v2.context.EventContext;

/**
 * @author gim 模板方法
 */
public abstract class AbstractEventFilter<T extends EventContext> implements EventFilter<T> {

    @Override
    public void doFilter(T context, EventFilterChain<T> chain) {
        //匹配节点是否执行
        if (context.getFilterSelector().matchFilter(this.getClass().getSimpleName())) {
            handle(context);
        }
        //是否执行下一个链节点
        if (context.continueChain()) {
            chain.fireNext(context);
        }
    }

    protected abstract void handle(T context);
}
