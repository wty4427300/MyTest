package com.design_patterns.pipeline.v2;

import com.design_patterns.pipeline.v2.context.EventContext;
import com.design_patterns.pipeline.v2.test.pojo.ChargeContext;
import org.springframework.stereotype.Component;

@Component
public class FilterChainPipeline<T extends EventContext, R extends EventFilter<T>> {
    private DefaultFilterChain<T> last;

    public FilterChainPipeline() {
    }

    public DefaultFilterChain<T> getFilterChain() {
        return this.last;
    }

    public FilterChainPipeline<T, R> addFirst(R filter) {
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }

    public FilterChainPipeline<T, R> addFirst(String desc, R filter) {
        this.last = new DefaultFilterChain<>(this.last, filter);
        return this;
    }
}
