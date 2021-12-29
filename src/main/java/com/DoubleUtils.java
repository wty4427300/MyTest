package com;

import com.ftest.MyThread.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ROUND_UP         向远离零的方向舍入
 * ROUND_DOWN       向接近零的方向舍入
 * ROUND_HALF_UP    四舍五入
 * ROUND_HALF_DOWN  五舍六入
 *
 * */
public class DoubleUtils extends Main {

    public static Double toScale2(String number){
        BigDecimal b = new BigDecimal(number);
        double result = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return result;
    }

    public static Double toScale2(Double number){
        BigDecimal b = new BigDecimal(Double.toString(number));
        double result = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return result;
    }

    /**
     * 提供精确的加法运算。
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static Double add(Double value1, Double value2 ) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(Double value1, Double value2) {

        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        try {
            double result = b1.subtract(b2).setScale(2).doubleValue();
            return result;
        }catch ( ArithmeticException ignored){
        }
        return b1.subtract(b2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static Double mul(Double value1, Double value2,RoundingMode rm) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        BigDecimal discountPrice = b1.multiply(b2).setScale(2,rm);
        return discountPrice.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("bbbb");
    }
}
