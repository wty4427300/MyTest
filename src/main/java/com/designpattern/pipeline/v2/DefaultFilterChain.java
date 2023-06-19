package com.designpattern.pipeline.v2;

import com.designpattern.pipeline.v2.context.EventContext;

import java.util.Objects;

/**
 * @author gim
 */
public class DefaultFilterChain<T extends EventContext> implements EventFilterChain<T> {

    private EventFilterChain<T> next;
    private EventFilter<T> filter;

    public DefaultFilterChain(EventFilterChain<T> chain, EventFilter<T> filter) {
        this.next = chain;
        this.filter = filter;
    }

    @Override
    public void handle(T context) {
        filter.doFilter(context, this);
    }

    @Override
    public void fireNext(T ctx) {
        EventFilterChain<T> nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(ctx);
        }
    }
}
