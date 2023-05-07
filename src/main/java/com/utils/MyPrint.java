package com.utils;

public class MyPrint {

    public static void printfWithColor(String format, Object... args) {
        //定义 ANSI 颜色码数组
        String[] colors = new String[]{
                "\u001B[31m", // 红色
                "\u001B[32m", // 绿色
                "\u001B[33m", // 黄色
                "\u001B[34m", // 蓝色
                "\u001B[35m", // 紫色
                "\u001B[36m"  // 青色
        };

        //随机选择一个颜色
        int index = (int) (Math.random() * colors.length);
        String color = colors[index];
        //将颜色码和格式化字符串拼接并输出
        System.out.print(color);
        System.out.printf(format, args);
    }
}
