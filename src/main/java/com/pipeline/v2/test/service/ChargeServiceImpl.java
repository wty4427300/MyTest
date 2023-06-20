package com.pipeline.v2.test.service;

import com.pipeline.v2.BizEnum;
import com.pipeline.v2.EventFilter;
import com.pipeline.v2.FilterChainPipeline;
import com.pipeline.v2.context.EventContext;
import com.pipeline.v2.selector.FilterSelector;
import com.pipeline.v2.test.pojo.ChargeContext;
import com.pipeline.v2.test.pojo.ChargeModel;
import com.pipeline.v2.test.pojo.ChargeRequest;
import com.pipeline.v2.test.selector.ChargeFilterSelectorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChargeServiceImpl implements IChargeService {

    private final FilterChainPipeline<EventFilter<EventContext>> chargePipeline;

    private final ChargeFilterSelectorFactory chargeFilterSelectorFactory;

    private final PluginRegistry<IChargeModelHandler, ChargeModel> pluginRegistry;

    @Override
    public void handle(ChargeRequest chargeRequest) {
        FilterSelector filterSelector = chargeFilterSelectorFactory.getFilterSelector(chargeRequest);
        ChargeContext chargeContext = new ChargeContext(BizEnum.METRIC_EVENT, filterSelector);
        chargeContext.setChargeRequest(chargeRequest);
        chargePipeline.getFilterChain().handle(chargeContext);
        ChargeModel chargeModel = chargeContext.getChargeModel();
        pluginRegistry.getPluginsFor(chargeModel)
                .forEach(handler -> handler.handleChargeModel(chargeModel));
    }
}
