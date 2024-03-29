package com.design_patterns.pipeline.v2.test.filters;

import com.design_patterns.pipeline.v2.filter.AbstractEventFilter;
import com.design_patterns.pipeline.v2.test.pojo.ChargeContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LogSaveFilter extends AbstractEventFilter<ChargeContext> {

  @Override
  protected void handle(ChargeContext context) {
    log.info("请求存储，发送到mq");
  }
}
