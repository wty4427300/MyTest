package com.designpattern.pipeline.v2;

import com.designpattern.pipeline.v2.context.EventContext;

public class FilterChainPipeline<T extends EventFilter<T> & EventContext> {
    private DefaultFilterChain<T> last;

    public FilterChainPipeline() {
    }

    public DefaultFilterChain<T> getFilterChain() {
        return this.last;
    }

    public FilterChainPipeline<T> addFirst(T filter) {
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }

    public FilterChainPipeline<T> addFirst(String desc, T filter) {
        System.out.println(desc);
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }
}
