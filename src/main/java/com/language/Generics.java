package com.language;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 派生类用于包裹泛型类型保存泛型信息
 * 例如
 * new Wrapper<List<String>>()
 */
class Wrapper<T> {
}

public class Generics {
    public static <T> Class<T> typeOf(T obj) {
        return (Class<T>) obj.getClass();
    }


    public static <T> Type getGenericRuntimeType(Wrapper<T> wrapper) {
        Type type = wrapper.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }

    public static <T> Class<T> getGenericRuntime(T ogj) {
        Type type = ogj.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            return (Class<T>) types[0].getClass();
        }
        return null;
    }

    public static void main(String[] args) {
        Class<Wrapper<List<String>>> wrapperClass = Generics.typeOf(new Wrapper<>());
        Type type1 = getGenericRuntimeType(new Wrapper<List<String>>());
        System.out.println(type1);
        Type type2 = getGenericRuntimeType(new Wrapper<List<String>>() {
        });
        Class<ArrayList<Integer>> genericRuntime = getGenericRuntime(new ArrayList<>());
        System.out.println(type2);
    }
}
