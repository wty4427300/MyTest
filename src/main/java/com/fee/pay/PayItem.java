package com.fee.pay;

import java.math.BigDecimal;

public interface PayItem {

  BigDecimal getMoney();

  PayGroup getPayGroup();

  PayType getPayType();

}
