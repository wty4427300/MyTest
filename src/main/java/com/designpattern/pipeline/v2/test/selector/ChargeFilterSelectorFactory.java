package com.designpattern.pipeline.v2.test.selector;

import com.designpattern.pipeline.v2.selector.FilterSelector;
import com.designpattern.pipeline.v2.test.pojo.ChargeRequest;

public interface ChargeFilterSelectorFactory {


  FilterSelector getFilterSelector(ChargeRequest request);


}
