package com.ftest.test;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.stream.Collectors;

public class test8 {
    public static void main(String[] args) {
        String a ="35TYA9XH\n" +
                "WW4444WT\n" +
                "6DNABESC\n" +
                "892CK2A2\n" +
                "YU2PXT6R\n" +
                "XJ656GV4\n" +
                "JQJWCSRG\n" +
                "5GEMHH6H\n" +
                "7U5NZJ63\n" +
                "ZJENTZQV\n" +
                "9P5RT2DP\n" +
                "VHLKFFAS\n" +
                "EUXA8V33\n" +
                "JM9G23XY\n" +
                "WDLW85TC\n" +
                "F8YK9DUV\n" +
                "FGT6AMHW\n" +
                "3XSDW4BX\n" +
                "K5LFTYFM\n" +
                "H3989YP7\n" +
                "RM8STHXS\n" +
                "CVHGUZCB\n" +
                "FNQS7ZH7\n" +
                "2UZ4UZP8\n" +
                "STR6G88T\n" +
                "QKH4HMWQ\n" +
                "ZULXRMJL\n" +
                "VC2HBM2M\n" +
                "7XWVUFGN\n" +
                "3DESEXUE\n" +
                "FX4HW539\n" +
                "5JFA5HY3\n" +
                "W3VB85Z5\n" +
                "DWWDAS6F\n" +
                "2UEEEQFL\n" +
                "5TGB38CF\n" +
                "DMSYTM8R\n" +
                "YWZU5ZPV\n" +
                "M586UZAX\n" +
                "VVYW3SU6\n" +
                "JKTY8Y2R\n" +
                "2KCS9AVH\n" +
                "2MUUF9Y6\n" +
                "HY2GPQA2\n" +
                "3T25ZCFX\n" +
                "T437ZQYC\n" +
                "VNGLSP3M\n" +
                "CSKSXJW7\n" +
                "7U8NCLJH\n" +
                "G8B9GL5U\n" +
                "KVGKAVMS\n" +
                "5CJY3YN8\n" +
                "XT98PYTR\n" +
                "CSPYXYBG\n" +
                "2C8Y62XW\n" +
                "DGLTHUJ6\n" +
                "BV3UQQWV\n" +
                "RCWUVGNC\n" +
                "K8H664YU\n" +
                "6ZVYCDDF\n" +
                "55HUMXW2\n" +
                "MS35UZX9\n" +
                "ATHNM5K8\n" +
                "XPY3UKJV\n" +
                "X8BGPJRS\n" +
                "CUS8UR43\n" +
                "XM6KPHG3\n" +
                "HTMJEVCB\n" +
                "YR5MFVXT\n" +
                "Z8EN83QW\n" +
                "HY9BCKRJ\n" +
                "ANXQK9WV\n" +
                "KXJKYXNQ\n" +
                "YAP685XZ\n" +
                "8RBRDB24\n" +
                "RCCPK2TL\n" +
                "5AW6HZ9T\n" +
                "DFQ7FZ3T\n" +
                "L8YAWL4B\n" +
                "JQ3JNH5G\n" +
                "MZ5YH3S2\n" +
                "YFG4P56B\n" +
                "5YBAZ5UW\n" +
                "5KZDQN6L\n" +
                "SQ98MH62\n" +
                "RV5WVHRX\n" +
                "YY7XRHK4\n" +
                "LFH4UR6W\n" +
                "LMBVJBZ4\n" +
                "4SJ9CN7E\n" +
                "J74WSMVG\n" +
                "2UEPBKYU\n" +
                "FYBAL9S3\n" +
                "DCQAFUB3\n" +
                "TM3K8F2Q\n" +
                "48UF3YSJ\n" +
                "GSVFYJT7\n" +
                "9PPWB9LW\n" +
                "HWQLJ4Z7\n" +
                "YW5LK6WS";
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
                    System.out.println("'"+it+"'"+ ",");
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
