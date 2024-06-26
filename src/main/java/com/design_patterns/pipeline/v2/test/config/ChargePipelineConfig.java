package com.design_patterns.pipeline.v2.test.config;

import com.design_patterns.pipeline.v2.FilterChainPipeline;
import com.design_patterns.pipeline.v2.test.filters.CarInfoQueryFilter;
import com.design_patterns.pipeline.v2.test.filters.JudgeCarFilter;
import com.design_patterns.pipeline.v2.test.filters.LogSaveFilter;
import com.design_patterns.pipeline.v2.test.filters.UserPayFilter;
import com.design_patterns.pipeline.v2.filter.EventFilter;
import com.design_patterns.pipeline.v2.test.pojo.ChargeContext;
import com.design_patterns.pipeline.v2.test.service.IFacadeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.design_patterns.pipeline.v2")
public class ChargePipelineConfig {

    @Resource
    private IFacadeService facadeService;

    @Bean
    public FilterChainPipeline<ChargeContext,EventFilter<ChargeContext>> chargePipeline() {
        FilterChainPipeline<ChargeContext,EventFilter<ChargeContext>> filterChainPipeline = new FilterChainPipeline<>();
        filterChainPipeline.addFirst("用户逻辑", userPayFilter());
        filterChainPipeline.addFirst("车辆信息判断", judgeCarFilter());
        filterChainPipeline.addFirst("车辆信息查询", carInfoQueryFilter());
        filterChainPipeline.addFirst("log存储", logSaveFilter());
        return filterChainPipeline;
    }

    @Bean
    public EventFilter<ChargeContext> carInfoQueryFilter() {
        return new CarInfoQueryFilter(facadeService);
    }

    @Bean
    public EventFilter<ChargeContext> judgeCarFilter() {
        return new JudgeCarFilter();
    }

    @Bean
    public EventFilter<ChargeContext> logSaveFilter() {
        return new LogSaveFilter();
    }

    @Bean
    public EventFilter<ChargeContext> userPayFilter() {
        return new UserPayFilter();
    }


}
