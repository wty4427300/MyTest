package com.design_patterns.pipeline.v2.test.selector;

import com.design_patterns.pipeline.v2.selector.FilterSelector;
import com.design_patterns.pipeline.v2.test.pojo.ChargeRequest;

public interface ChargeFilterSelectorFactory {


  FilterSelector getFilterSelector(ChargeRequest request);


}
