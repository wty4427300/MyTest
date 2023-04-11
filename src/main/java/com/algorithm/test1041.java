package com.algorithm;

public class test1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        for (int idx = 0; idx < n; idx++) {
            char c = instructions.charAt(idx);
            switch (c) {
                case 'G':
                    x += direc[index][0];
                    y += direc[index][1];
                    break;
                case 'L':
                    //取方向
                    index += 3;
                    //4次循环回到原地
                    index %= 4;
                    break;
                default:
                    index++;
                    index %= 4;
                    break;
            }
        }
        return index != 0 || (x == 0 && y == 0);
    }

    public static void main(String[] args) {
        String s="GGLLGG";
        test1041 test1041=new test1041();
        boolean robotBounded = test1041.isRobotBounded(s);
        System.out.println(robotBounded);
    }
}
