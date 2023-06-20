package com.designpattern.pipeline.v2;

import com.designpattern.pipeline.v2.context.EventContext;

public class FilterChainPipeline<T extends EventFilter<EventContext>> {
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
