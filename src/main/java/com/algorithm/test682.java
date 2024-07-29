package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test682 {
    public int calPoints(String[] operations) {
        int res = 0;
        List<Integer> points = new ArrayList<>();
        for (String op : operations) {
            int n = points.size();
            switch (op) {
                case "+":
                    res += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                    break;
                case "D":
                    res += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                    break;
                case "C":
                    res -= points.get(n - 1);
                    points.remove(n - 1);
                    break;
                default:
                    res += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] operations = {"5", "2", "C", "D", "+"};
        System.out.println(new test682().calPoints(operations));
    }
}
