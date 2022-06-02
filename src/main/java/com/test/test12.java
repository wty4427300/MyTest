package com.test;

public class test12 {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
//        List<Integer> list1 = integers.subList(0, 2);
//        System.out.println(list1);
//        List<Integer> list2 = integers.subList(2, integers.size());
//        System.out.println(list2);
        int length=1000;
        int groupSize=200;
        int num = ( length + groupSize - 1 )/groupSize;
        System.out.println(num);
    }
}
