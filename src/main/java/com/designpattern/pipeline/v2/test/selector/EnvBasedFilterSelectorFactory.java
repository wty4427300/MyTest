package com.designpattern.pipeline.v2.test.selector;

import com.designpattern.pipeline.v2.selector.FilterSelector;
import com.designpattern.pipeline.v2.selector.LocalListBasedFilterSelector;
import com.designpattern.pipeline.v2.test.config.ChargeFilterConfigProperties;
import com.designpattern.pipeline.v2.test.pojo.ChargeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EnvBasedFilterSelectorFactory implements ChargeFilterSelectorFactory {

    private final ChargeFilterConfigProperties properties;

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
