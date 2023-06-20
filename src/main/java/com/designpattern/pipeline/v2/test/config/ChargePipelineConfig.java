package com.designpattern.pipeline.v2.test.config;

import com.designpattern.pipeline.v2.FilterChainPipeline;
import com.designpattern.pipeline.v2.test.filters.CarInfoQueryFilter;
import com.designpattern.pipeline.v2.test.filters.JudgeCarFilter;
import com.designpattern.pipeline.v2.test.filters.LogSaveFilter;
import com.designpattern.pipeline.v2.test.filters.UserPayFilter;
import com.designpattern.pipeline.v2.test.service.IFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChargePipelineConfig {

    @Autowired
    private IFacadeService facadeService;

    @Bean
    public FilterChainPipeline chargePipeline() {
        FilterChainPipeline filterChainPipeline = new FilterChainPipeline();
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
