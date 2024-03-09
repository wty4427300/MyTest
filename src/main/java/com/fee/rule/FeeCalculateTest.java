package com.fee.rule;

import com.fee.base.FeeCalculate;
import com.fee.base.FeeItem;
import com.fee.base.FeeItemType;
import com.fee.pay.PayItem;
import com.fee.rule.context.OrderInfo;
import com.fee.rule.factory.CalculatorFactory;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.MapUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class FeeCalculateTest {


    public void testFee() {
        //初始化规则
        List<FeeRule> ruleList = Lists.newArrayList();
        FreeTimesRule freeTimesRule = new FreeTimesRule(new BigDecimal(0), FeeRuleType.FREE_TIMES, 3);
        FreeTimeRule freeTimeRule = new FreeTimeRule(new BigDecimal(1), FeeRuleType.FREE_TIME, 1);
        PlusRule plusRule = new PlusRule(new BigDecimal("0.95"), FeeRuleType.PLUS_RULE, 4);
        MaxLimitRule maxLimitRule = new MaxLimitRule(new BigDecimal("1.4"), FeeRuleType.MAX_LIMIT, 5);

        ruleList.add(freeTimesRule);
        ruleList.add(freeTimeRule);
        ruleList.add(plusRule);
        ruleList.add(maxLimitRule);

        //排序规则
        List<FeeRule> sortRules = ruleList.stream().sorted(Comparator.comparingInt(FeeRule::getOrder))
                .toList();

        //初始化支付项
        List<FeeItem<OrderInfo>> payItemList = Lists.newArrayList();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCarNo("dddd");
        orderInfo.setParkTimes(3);
        orderInfo.setUserId(4L);
        orderInfo.setTotalMoney(new BigDecimal("30"));
        ParkingFeeItem parkingFeeItem = new ParkingFeeItem(orderInfo);
        payItemList.add(parkingFeeItem);

        //核心流程
        FeeCalculate<OrderInfo> calculate = null;
        for (FeeRule feeRule : sortRules) {
            //根据规则类型获取对应的计算器类型，生成FeeCalculate
            calculate = CalculatorFactory.getFeeCalculateByRuleType(calculate, feeRule);
        }
        //计算费用
        assert calculate != null;
        Map<FeeItemType, BigDecimal> waitPay = calculate.calculateWaitPay(payItemList);

        BigDecimal waitPayMoney = waitPay.get(FeeItemType.SERVICE_FEE);
        System.out.println("待支付金额" + waitPayMoney);

        Map<FeeItemType, List<PayItem>> map = calculate.payItemList(payItemList);

        MapUtils.debugPrint(System.out, "console", map);
        List<PayItem> payList = map.get(FeeItemType.SERVICE_FEE);
        payList.forEach(payItem -> {
                    System.out.println(payItem.getMoney());
                    System.out.println(payItem.getPayType());
                    System.out.println(payItem.getPayGroup());
                });
    }

    public static void main(String[] args) {
        FeeCalculateTest test = new FeeCalculateTest();
        test.testFee();
    }

}
