package com.algorithm;

public class test2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int r = purchaseAmount % 10;
        if (r<5){
            purchaseAmount -= r;
        }
        else{
            purchaseAmount += 10 - r;
        }
        return 100 - purchaseAmount;
    }
    public static void main(String[] args) {
        int purchaseAmount = 14;
        System.out.println(new test2806().accountBalanceAfterPurchase(purchaseAmount));
    }
}
