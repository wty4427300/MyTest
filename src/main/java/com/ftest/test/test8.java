package com.ftest.test;

import com.DoubleUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class test8 {
    public static void main(String[] args) {
        String a ="";
        String[] split = a.split("\n");
        List<AljkSyncCargoRequest> requests = Arrays.stream(split).map(
                it -> {
                    AljkSyncCargoRequest request = new AljkSyncCargoRequest();
                    request.setStoreId(Long.valueOf(it));
                    return request;
                }
        ).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(requests));
//        update(null,null);
//        price(collect);
//        sql(Arrays.stream(split).collect(Collectors.toList()));
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
//        Arrays.stream(split).forEach(
//                it->{
//                    String[] user = it.split("\t");
//                    System.out.println(
//                            "('"+user[0]+"', '"+user[1]+"', 0, now(), now(), 0, 0,'京东自营'),"
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
    public static void update(List<String> collect,Set<String> set){
        int a=2; int b=1;
        for (int i=0;i<70;i++){
            System.out.println("update channel_storesyn_rule set config_id="+a+" where id="+b+";");
            a++;
            b++;
        }
    }

    public static void sql(List<String> collect) {
        System.out.println("insert into channel_storesyn_rule (gmt_create, gmt_modified, config_id, rule_type, rule_judge, item_id, store_id, sold_price) values");
        collect.stream().forEach(
                it -> {
                    System.out.println("(now(),now(),1,'store',3,0,"+it+",0),");
                }
        );
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
    public static void price(List<String> collect){
        collect.stream().forEach(
                it->{
                    String[] split = it.split("\t");
                    if (split.length==11){
                        String s = split[7];
                        double statementPrice = 0;
                        if (s.equals("1")) {
                            //固定结算
                            statementPrice = split[10].equals("1") ?
                                    Double.parseDouble(split[9])
                                    : Double.parseDouble(split[8]);
                        } else {
                            //比例结算
                            //ROUND_UP：向远离零的方向舍入（若舍入位为非零，则对舍入部分的前一位数字加1；若舍入位为零，则直接舍弃。即为向外取整模式。）
                            //ROUND_DOWN:向零的方向舍入，因为这里计算的是优惠后的金额，所以向0的方向舍入
                            statementPrice = split[10].equals("1") ?
                                    DoubleUtils.mul(Double.parseDouble(split[5]),Double.parseDouble(StringUtils.isEmpty(split[9]) ?"0.0":split[9]), RoundingMode.DOWN)
                                    :
                                    DoubleUtils.mul(Double.parseDouble(split[5]),Double.parseDouble(StringUtils.isEmpty(split[8]) ?"0.0":split[9]),RoundingMode.DOWN);
                        }
                        System.out.println(Integer.valueOf(split[0])+","+statementPrice);
                    }
                }
        );
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
