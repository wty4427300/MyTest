package com.fee.test;

import com.fee.FeeCalculate;
import com.fee.FeeItem;
import com.fee.FeeItemType;
import com.fee.calculator.ActivityCalculator;
import com.fee.calculator.CouponCalculator;
import com.fee.pay.PayItem;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CalculateTest {

    public static void main(String[] args) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setTradeFlowNo("T0323423432");
        List<FeeItem<OrderInfo>> list = Lists.newArrayList();
        list.add(new ServiceFeeItem(orderInfo, FeeItemType.SERVICE_FEE, new BigDecimal(20)));
        FeeCalculate<OrderInfo> feeCalculate = new ActivityCalculator(new CouponCalculator(null));
        Map<FeeItemType, BigDecimal> leftPay = feeCalculate.calculateWaitPay(list);
        leftPay.forEach((k, v) -> {
            System.out.println("待支付项" + k.getName() + v.toPlainString() + "元");
        });
        Map<FeeItemType, List<PayItem>> payItemList = feeCalculate.payItemList(list);

        payItemList.forEach((k, v) -> {
            StringBuffer sb = new StringBuffer();
            v.forEach(p -> {
                sb.append("支付类型:").append(p.getPayType().getName());
                sb.append("支付金额:").append(p.getMoney()).append("元");
                sb.append(" ! ");
            });
            System.out.println("已经支付项" + k.getName() + sb);
        });
    }

}