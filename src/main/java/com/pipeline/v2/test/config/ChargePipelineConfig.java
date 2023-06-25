package com.pipeline.v2.test.config;

import com.pipeline.v2.AbstractEventFilter;
import com.pipeline.v2.EventFilter;
import com.pipeline.v2.FilterChainPipeline;
import com.pipeline.v2.context.EventContext;
import com.pipeline.v2.test.filters.CarInfoQueryFilter;
import com.pipeline.v2.test.filters.JudgeCarFilter;
import com.pipeline.v2.test.filters.LogSaveFilter;
import com.pipeline.v2.test.filters.UserPayFilter;
import com.pipeline.v2.test.pojo.ChargeContext;
import com.pipeline.v2.test.service.IFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.pipeline.v2.test.service")
public class ChargePipelineConfig {

    @Autowired
    private IFacadeService facadeService;

    private final EventFilter<? extends EventContext> filter = new AbstractEventFilter<ChargeContext>() {

        @Override
        protected void handle(ChargeContext context) {

        }
    };

    @Bean
    public FilterChainPipeline<AbstractEventFilter<ChargeContext>> chargePipeline() {
        FilterChainPipeline<AbstractEventFilter<ChargeContext>> filterChainPipeline = new FilterChainPipeline<>();
        filterChainPipeline.addFirst("用户逻辑", userPayFilter());
        filterChainPipeline.addFirst("车辆信息判断", judgeCarFilter());
        filterChainPipeline.addFirst("车辆信息查询", carInfoQueryFilter());
        filterChainPipeline.addFirst("log存储", logSaveFilter());
        return filterChainPipeline;
    }

    @Bean
    public AbstractEventFilter<ChargeContext> carInfoQueryFilter() {
        return new CarInfoQueryFilter(facadeService);
    }

    @Bean
    public AbstractEventFilter<ChargeContext> judgeCarFilter() {
        return new JudgeCarFilter();
    }

    @Bean
    public AbstractEventFilter<ChargeContext> logSaveFilter() {
        return new LogSaveFilter();
    }

    @Bean
    public AbstractEventFilter<ChargeContext> userPayFilter() {
        return new UserPayFilter();
    }


}
