package com.algorithm;

public class test640 {
    public String solveEquation(String equation) {
        String[] arr1 = equation.split("=");
        int left = 0, right = 0;
        String[] arr2 = arr1[0].replace("-", "+-").split("\\+");
        String[] arr3 = arr1[1].replace("-", "+-").split("\\+");
        //把x移到左边，把其他移到右边
        //处理等式左边
        for (String s : arr2) {
            if (s.equals("x")) {
                //x
                left += 1;
            } else if (s.equals("-x")) {
                //x
                left += -1;
            } else if (s.contains("x")) {
                //nx
                left += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                //num
                right -= Integer.parseInt(s);
            }
        }
        //处理等式右边
        for (String s : arr3) {
            if (s.equals("x")) {
                left -= 1;
            } else if (s.equals("-x")) {
                left -= -1;
            } else if (s.contains("x")) {
                left -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                right += Integer.parseInt(s);
            }
        }
        if (left == 0) {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + right / left;
        }
    }

    public static void main(String[] args) {
        String x = "x+5-3+x=6+x-2";
        test640 test640 = new test640();
        String result = test640.solveEquation(x);
        System.out.println(result);
    }
}
