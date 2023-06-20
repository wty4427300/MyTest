package com.pipeline.v2;

import com.pipeline.v2.context.EventContext;
import org.springframework.stereotype.Component;

@Component
public class FilterChainPipeline<T extends AbstractEventFilter<? extends EventContext>> {
    private DefaultFilterChain<EventContext> last;

    public FilterChainPipeline() {
    }

    public DefaultFilterChain<EventContext> getFilterChain() {
        return this.last;
    }

    public FilterChainPipeline<T> addFirst(T filter) {
        this.last = new DefaultFilterChain<>(this.last, (AbstractEventFilter<EventContext>) filter);
        return this;
    }

    public FilterChainPipeline<T> addFirst(String desc, T filter) {
        this.last = new DefaultFilterChain<>(this.last, (AbstractEventFilter<EventContext>) filter);
        return this;
    }
}
