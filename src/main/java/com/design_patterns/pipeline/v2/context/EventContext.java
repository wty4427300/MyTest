package com.design_patterns.pipeline.v2.context;

import com.design_patterns.pipeline.v2.selector.FilterSelector;
import com.design_patterns.pipeline.v2.BizEnum;

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
