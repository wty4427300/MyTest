package com.pipeline.v2.test.selector;

import com.pipeline.v2.selector.FilterSelector;
import com.pipeline.v2.test.pojo.ChargeRequest;

public interface ChargeFilterSelectorFactory {


  FilterSelector getFilterSelector(ChargeRequest request);


}
