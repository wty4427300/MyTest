package com.algorithm;

public class test1017 {
    public String baseNeg2(int n) {
        if(n==0){
            return "0";
        }
        int k=1;
        StringBuilder ans=new StringBuilder();
        while (n!=0){
            if (n%2!=0){
                ans.append(1);
                n-=k;
            }else {
                ans.append(0);
            }
            k*=-1;
            n/=2;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        int n=5;
        test1017 test1017=new test1017();
        String s = test1017.baseNeg2(n);
        System.out.println(s);
    }
}
