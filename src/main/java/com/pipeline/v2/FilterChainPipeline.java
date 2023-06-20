package com.pipeline.v2;

import com.pipeline.v2.context.AbstractEventContext;
import com.pipeline.v2.context.EventContext;

public class FilterChainPipeline<T extends EventFilter<AbstractEventContext>> {
    private DefaultFilterChain<EventContext> last;

    public FilterChainPipeline() {
    }

    public DefaultFilterChain<EventContext> getFilterChain() {
        return this.last;
    }

    public FilterChainPipeline<T> addFirst(T filter) {
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }

    public FilterChainPipeline<T> addFirst(String desc, T filter) {
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }
}
