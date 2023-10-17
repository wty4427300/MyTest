package com.algorithm;

public class test2652 {
    public int sumOfMultiples(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            if (i%3==0||i%5==0||i%7==0){
                ans+=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test2652 test2652=new test2652();
        int i = test2652.sumOfMultiples(7);
        System.out.println(i);
    }
}
