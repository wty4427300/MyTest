package com.design_patterns.pipeline.v2;

import com.design_patterns.pipeline.v2.context.EventContext;
import com.design_patterns.pipeline.v2.filter.EventFilter;

import java.util.Objects;

/**
 * @author gim
 */
public class DefaultFilterChain<T extends EventContext> implements EventFilterChain<T> {

    private final EventFilterChain<T> next;
    private final EventFilter<T> filter;

    public DefaultFilterChain(EventFilterChain<T> next, EventFilter<T> filter) {
        this.next = next;
        this.filter = filter;
    }

    @Override
    public void handle(T context) {
        filter.doFilter(context, this);
    }

    @Override
    public void fireNext(T context) {
        EventFilterChain<T> nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(context);
        }
    }
}
