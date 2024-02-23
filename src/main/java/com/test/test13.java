package com.test;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Data
class UserT {
    private int id;
    private String name;
}

public class test13 {

    public static int changeY2F(double price) {
        DecimalFormat df = new DecimalFormat("#.00");
        price = Double.valueOf(df.format(price));
        return (int) (price * 100.0D);
    }

    public static int changeY2F1(double price) {
        BigDecimal bd = new BigDecimal(price);
        BigDecimal result = bd.multiply(new BigDecimal(100)).setScale(0, RoundingMode.HALF_UP);
        return result.intValue();
    }

    public static int changeY2F2(double price) {
        BigDecimal yuan = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        BigDecimal fen = yuan.multiply(new BigDecimal(100)).setScale(0, RoundingMode.HALF_UP);
        int money = fen.intValue();
        return money;
    }

    public static void main(String[] args) {
        int i = changeY2F2(1260.60);
        System.out.println(i);
    }
}
