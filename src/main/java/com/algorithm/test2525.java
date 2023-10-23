package com.algorithm;

public class test2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        //最大维度
        long maxd = Math.max(length, Math.max(width, height));
        //体积
        long vol = (long) length * width * height;
        boolean isBulky = maxd >= 10000 || vol >= 1000000000, isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
