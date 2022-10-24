package com.algorithm;

public class test1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnts = new int[2];
        for (int x : students) {
            cnts[x]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            //当栈顶面包无法匹配到学生的时候,后续学生都无法吃到心仪的面包
            if (--cnts[sandwiches[i]] == -1) {
                return sandwiches.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 1, 0, 0, 1}, sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        test1700 test1700 = new test1700();
        int i = test1700.countStudents(students, sandwiches);
        System.out.println(i);
    }
}
