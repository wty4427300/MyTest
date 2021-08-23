package com.ftest.test;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.stream.Collectors;

public class test8 {
    public static void main(String[] args) {
        String a ="49580\n" +
                "49646\n" +
                "49383\n" +
                "49497\n" +
                "49498";
        String[] split = a.split("\n");
        List<String> collect = Arrays.stream(split).collect(Collectors.toList());
//        System.out.println(collect.size());
//        collect.forEach(
//                it->{
//                    System.out.println("('"+uuid()+"',10183,'洗牙保健兑换券',"+it+",now(),now(),0,'2021-06-21 13:30:28','2022-06-21 13:30:28'),");
//                }
//        );

//        Set<String> set=new HashSet<>();
//        String[] p = a.split("\n");
//        Arrays.stream(p).forEach(
//                it->{
//                    boolean add = set.add(it);
//                    if (!add){
//                        System.out.println("重复："+it);
//                    }
//                }
//        );
//        System.out.println(set.size());
//        String[] z = b.split("\n");
//        Arrays.stream(z).forEach(
//                it->{
//                    boolean add = set.add(it);
//                    if (add){
//                        System.out.println(it);
//                    }
//                }
//        );

        sql(collect);

//        Arrays.stream(split).forEach(
//                it->{
//                    String[] user = it.split("\t");
//                    System.out.println(
//                            "('"+user[0]+"', '"+user[1]+"', 0, now(), now(), 0, 0,'平安健康'),"
//                    );
//                }
//        );

//        List<String> collect = Arrays.stream(split).map(
//                it -> {
//                    return it;
//                }
//        ).collect(Collectors.toList());
//        sql(collect);
//        json2(collect);
//        String b = "虹桥商务区2路";
//        String[] split1 = b.split(";");
//        System.out.println(split1.length);
//        System.out.println(collect.size());
//        collect.forEach(
//                it->{
//                    System.out.println("('2021-06-21 13:30:28','2022-06-21 13:30:28',19,"+it+",158.00,550.00,0,0,68),");
//                }
//        );
    }

    public static void sql(List<String> collect) {
        System.out.println("(");
        collect.stream().forEach(
                it -> {
                    System.out.println(it+ ",");
//                    System.out.println("'"+it+"'"+ ",");
                }
        );
        System.out.println(")");
    }

    public static void json1(List<Integer> collect) {
        System.out.println("[");
        collect.stream().forEach(
                it -> {
                    System.out.println("{\"dentalStoreId\":" + it + "},");
                }
        );
        System.out.println("]");
    }

    public static void json2(List<String> collect) {
        System.out.println("[");
        collect.stream().forEach(
                it -> {
                    System.out.println("\"" + it + "\"" + ",");
                }
        );
        System.out.println("]");
    }


    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
