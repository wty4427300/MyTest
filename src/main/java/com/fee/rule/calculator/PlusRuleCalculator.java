package com.fee.rule.calculator;

import cn.hutool.core.util.NumberUtil;
import com.fee.AbstractCalculator;
import com.fee.FeeCalculate;
import com.fee.FeeItemType;
import com.fee.Unique;
import com.fee.pay.PayGroup;
import com.fee.pay.PayItem;
import com.fee.pay.PayType;
import com.fee.rule.context.OrderInfo;
import com.fee.rule.mockbean.UserService;
import com.fee.rule.payitem.PlusPayItem;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * plus 会员
 */
public class PlusRuleCalculator extends AbstractCalculator<OrderInfo> {

  private final BigDecimal discount;

  private UserService.UserInfo userInfo;

  private Optional<BigDecimal> payMoney = Optional.empty();

  public PlusRuleCalculator(FeeCalculate feeCalculate, Unique unique, BigDecimal discount) {
    super(feeCalculate, unique);
    this.discount = discount;
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
                                                        OrderInfo o) {
    BigDecimal serviceFee = left.get(FeeItemType.SERVICE_FEE);
    Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
    // 查询用户信息
    UserService userService = new UserService();
    UserService.UserInfo userInfo = userService.getUserInfo(o.getUserId());
    this.userInfo = userInfo;
    if(userInfo.isPlus()){
      if(NumberUtil.isGreater(serviceFee,BigDecimal.ZERO)){
        map.put(FeeItemType.SERVICE_FEE,NumberUtil.mul(discount,serviceFee));
        this.payMoney = Optional.of(NumberUtil.mul(discount,serviceFee));
      }
    }
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType,List<PayItem>> maps = Maps.newHashMap();
    if(payMoney.isPresent()){
      List<PayItem> list = Lists.newArrayList();
      PlusPayItem plusPayItem = new PlusPayItem(payMoney.get(), PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
      plusPayItem.setPlusNo(userInfo.getPlusNo());
      list.add(plusPayItem);
      maps.put(FeeItemType.SERVICE_FEE,list);
    }
    return maps;
  }
}
