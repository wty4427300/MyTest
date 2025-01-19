package com.test;

import java.lang.reflect.Method;


class Bean {
    int id=1;
    public int getId() {
        return id;
    }
}
public class test7 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Method methodGetId = Bean.class.getMethod("getId");
        Bean bean = (Bean) Class.forName("com.test.Bean").getDeclaredConstructor().newInstance();
        int value = (Integer) methodGetId.invoke(bean);
        System.out.println(value);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start);
        java.util.function.ToIntFunction<Bean> function = Bean::getId;
        int i = function.applyAsInt(bean);
        System.out.println(i);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-end1);
    }
}
