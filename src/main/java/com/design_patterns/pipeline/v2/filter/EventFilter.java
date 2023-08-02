package com.design_patterns.pipeline.v2.filter;


import com.design_patterns.pipeline.v2.EventFilterChain;
import com.design_patterns.pipeline.v2.context.EventContext;

/**
 * @author gim
 */
public interface EventFilter<T extends EventContext> {

    /**
     * 过滤逻辑封装点
     *
     * @param context
     * @param chain
     */
    void doFilter(T context, EventFilterChain<T> chain);


}
