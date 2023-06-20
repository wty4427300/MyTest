package com.pipeline.v2;


import com.pipeline.v2.context.AbstractEventContext;
import com.pipeline.v2.context.EventContext;

/**
 * @author gim 模板方法
 */
public abstract class AbstractEventFilter<T extends AbstractEventContext> implements EventFilter<T> {

    @Override
    public void doFilter(T context, EventFilterChain<T> chain) {
        if (context.getFilterSelector().matchFilter(this.getClass().getSimpleName())) {
            handle(context);
        }
        if (context.continueChain()) {
            chain.fireNext(context);
        }
    }

    protected abstract void handle(T context);
}
