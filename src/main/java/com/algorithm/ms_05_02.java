package com.algorithm;

public class ms_05_02 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length()<=32 && num!=0){
            num*=2;
            int digit=(int) num;
            //整数部分添加
            sb.append(digit);
            num-=digit;
        }
        return sb.length()<=32?sb.toString():"ERROR";
    }

    public static void main(String[] args) {
        double num=0.625;
        ms_05_02 ms_05_02=new ms_05_02();
        String s = ms_05_02.printBin(num);
        System.out.println(s);
    }
}
