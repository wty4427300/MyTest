package com.algorithm;

public class test2591 {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money > 8 * children) {
            return children - 1;
        }
        if (money == 8 * children - 4) {
            return children - 2;
        }
        // money-8x >= children-x, x <= (money-children)/7
        return (money - children) / 7;
    }

    public static void main(String[] args) {
        test2591 test2591 = new test2591();
        int i = test2591.distMoney(2, 2);
        System.out.println(i);
    }
}
