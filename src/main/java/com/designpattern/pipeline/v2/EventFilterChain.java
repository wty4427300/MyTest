package com.designpattern.pipeline.v2;


import com.designpattern.pipeline.v2.context.EventContext;

/**
 * @author gim
 */
public interface EventFilterChain<T extends EventContext> {


  /**
   * 事件处理流程
   * @param context
   */
  void handle(T context);

  /**
   * 开启下一个鉴权
   * @param ctx
   */
  void fireNext(T ctx);

}
