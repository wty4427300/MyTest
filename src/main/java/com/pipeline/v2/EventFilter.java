package com.pipeline.v2;


import com.pipeline.v2.context.EventContext;

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
