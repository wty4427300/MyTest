package com.fee.test;

import com.fee.base.FeeCalculate;
import com.fee.base.FeeItem;
import com.fee.base.FeeItemType;
import com.fee.pay.PayItem;
import com.fee.test.calculator.ActivityCalculator;
import com.fee.test.calculator.CouponCalculator;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CalculateTest {

    public static void main(String[] args) {
        //初始化一个简单的订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setTradeFlowNo("T0323423432");
        orderInfo.setOrderType("普通订单");
        orderInfo.setPayAmount(new BigDecimal(String.valueOf(BigDecimal.ZERO)));
        orderInfo.setServiceFee(new BigDecimal(20));
        //初始化服务费用
        List<FeeItem<OrderInfo>> list = Lists.newArrayList();
        list.add(new ServiceFeeItem(orderInfo, FeeItemType.SERVICE_FEE, orderInfo.getServiceFee()));
        //编排算子
        FeeCalculate<OrderInfo> feeCalculate = new ActivityCalculator(new CouponCalculator(null));
        //获取待支付金额
        Map<FeeItemType, BigDecimal> leftPay = feeCalculate.calculateWaitPay(list);
        leftPay.forEach((k, v) -> {
            System.out.println("待支付项:" + k.getName() + v.toPlainString() + "元");
        });
        //抵扣项展示
        Map<FeeItemType, List<PayItem>> payItemList = feeCalculate.payItemList(list);
        payItemList.forEach((k, v) -> {
            StringBuffer sb = new StringBuffer();
            v.forEach(p -> {
                sb.append("支付类型:").append(p.getPayType().getName());
                sb.append("支付金额:").append(p.getMoney()).append("元");
                sb.append(" ! ").append("\n");
            });
            System.out.println("已经抵扣:\n" + k.getName() + "\n" + sb);
        });
    }

}
