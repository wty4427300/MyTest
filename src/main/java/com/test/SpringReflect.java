package com.test;

import com.alibaba.fastjson2.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * spring排除static相关信息的代码,小抄一手
 */
public class SpringReflect {
    private String name;
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

    public static String getDesc() {
        return desc;
    }

    public static void setDesc(String desc) {
        SpringReflect.desc = desc;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.test.SpringReflect");
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
    }
}
