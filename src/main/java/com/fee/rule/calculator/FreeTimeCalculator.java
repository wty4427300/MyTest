package com.fee.rule.calculator;

import com.fee.AbstractCalculator;
import com.fee.FeeCalculate;
import com.fee.FeeItemType;
import com.fee.Unique;
import com.fee.pay.PayGroup;
import com.fee.pay.PayItem;
import com.fee.pay.PayType;
import com.fee.rule.context.OrderInfo;
import com.fee.rule.payitem.FreeTimePayItem;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class FreeTimeCalculator extends AbstractCalculator<OrderInfo> {

    private final Integer freeTime;

    public FreeTimeCalculator(FeeCalculate feeCalculate,
                              Unique unique, Integer freeTime) {
        super(feeCalculate, unique);
        this.freeTime = freeTime;
    }

    @Override
    protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
                                                          OrderInfo o) {
        Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
        map.put(FeeItemType.SERVICE_FEE, BigDecimal.ZERO);
        return map;
    }

    @Override
    protected Map<FeeItemType, List<PayItem>> payItemList() {
        Map<FeeItemType, List<PayItem>> itemMaps = Maps.newHashMap();
        List<PayItem> List = Lists.newArrayList();
        FreeTimePayItem freeTimePayItem = new FreeTimePayItem(new BigDecimal(freeTime), PayType.ACTIVITY, PayGroup.VIRTUAL_PROPERTY);
        List.add(freeTimePayItem);
        itemMaps.put(FeeItemType.SERVICE_FEE, List);
        return itemMaps;
    }
}
