package com.utils;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * spring排除static相关信息的代码,小抄一手
 */
public class SpringReflect {
    private String name;
    @Getter
    private static String desc;

    public SpringReflect() {
    }

    public SpringReflect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setDesc(String desc) {
        SpringReflect.desc = desc;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.utils.SpringReflect");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                System.out.println("static:" + field.getName());
            } else {
                System.out.println("普通:" + field.getName());
            }
        }
        SpringReflect test = (SpringReflect) aClass.newInstance();
        SpringReflect.setDesc("小张");
        test.setName("小王");
        System.out.println(JSON.toJSONString(test));
        System.out.println(desc);


        Class<?> outerClass = Class.forName("java.util.concurrent.ThreadPoolExecutor");
        // 2. 获取外部类中声明的所有类
        Class<?>[] declaredClasses = outerClass.getDeclaredClasses();

        // 3. 迭代这些类，查找私有内部类
        for (Class<?> innerClass : declaredClasses) {
            // 使用 Modifier 类的 isPrivate() 方法检查修饰符
            if (Modifier.isPrivate(innerClass.getModifiers())) {
                System.out.println("Found private inner class: " + innerClass.getName());
            }
        }
    }
}
