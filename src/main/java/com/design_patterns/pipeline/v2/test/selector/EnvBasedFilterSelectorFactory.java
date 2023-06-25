package com.design_patterns.pipeline.v2.test.selector;

import com.design_patterns.pipeline.v2.selector.FilterSelector;
import com.design_patterns.pipeline.v2.selector.LocalListBasedFilterSelector;
import com.design_patterns.pipeline.v2.test.config.ChargeFilterConfigProperties;
import com.design_patterns.pipeline.v2.test.pojo.ChargeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@ComponentScan("com.pipeline.v2.test.config")
public class EnvBasedFilterSelectorFactory implements ChargeFilterSelectorFactory {

    @Autowired
    private ChargeFilterConfigProperties properties;

    @Override
    public FilterSelector getFilterSelector(ChargeRequest request) {
        String bizCode = request.getBizCode();
        if ("YW1".equals(bizCode)) {
            List<String> filterNames = properties.getConfigs()
                    .getOrDefault("YW1", Collections.unmodifiableList(new ArrayList<>()));
            return new LocalListBasedFilterSelector(filterNames);
        }
        return null;
    }
}
