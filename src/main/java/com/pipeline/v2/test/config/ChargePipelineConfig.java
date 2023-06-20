package com.pipeline.v2.test.config;

import com.pipeline.v2.AbstractEventFilter;
import com.pipeline.v2.FilterChainPipeline;
import com.pipeline.v2.context.AbstractEventContext;
import com.pipeline.v2.test.filters.CarInfoQueryFilter;
import com.pipeline.v2.test.filters.JudgeCarFilter;
import com.pipeline.v2.test.filters.LogSaveFilter;
import com.pipeline.v2.test.filters.UserPayFilter;
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

    @Bean
    public FilterChainPipeline<AbstractEventFilter<AbstractEventContext>> chargePipeline() {
        FilterChainPipeline<AbstractEventFilter<AbstractEventContext>> filterChainPipeline = new FilterChainPipeline<>();
        filterChainPipeline.addFirst("用户逻辑", userPayFilter());
        filterChainPipeline.addFirst("车辆信息判断", judgeCarFilter());
        filterChainPipeline.addFirst("车辆信息查询", carInfoQueryFilter());
        filterChainPipeline.addFirst("log存储", logSaveFilter());
        return filterChainPipeline;
    }

    @Bean
    public CarInfoQueryFilter carInfoQueryFilter() {
        return new CarInfoQueryFilter(facadeService);
    }

    @Bean
    public JudgeCarFilter judgeCarFilter() {
        return new JudgeCarFilter();
    }

    @Bean
    public LogSaveFilter logSaveFilter() {
        return new LogSaveFilter();
    }

    @Bean
    public UserPayFilter userPayFilter() {
        return new UserPayFilter();
    }


}
