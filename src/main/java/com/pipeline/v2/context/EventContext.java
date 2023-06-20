package com.pipeline.v2.context;

import com.pipeline.v2.BizEnum;
import com.pipeline.v2.selector.FilterSelector;

/**
 * 上下文
 */
public interface EventContext {

    /**
     * 获取业务编码
     *
     * @return
     */
    BizEnum getBizCode();

    /**
     * 获取过滤器选择器
     *
     * @return
     */
    FilterSelector getFilterSelector();

    /**
     * 是否继续链
     *
     * @return
     */
    boolean continueChain();
}
