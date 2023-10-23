package com.algorithm;

public class test2678 {
    public int countSeniors(String[] details) {
        int res=0;
        for (String str:details){
            int age = Integer.parseInt(str.substring(11, 13));
            if (age>60){
                res+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] info=new String[]{"7868190130M7522"};
        test2678 test2678=new test2678();
        test2678.countSeniors(info);
    }
}
