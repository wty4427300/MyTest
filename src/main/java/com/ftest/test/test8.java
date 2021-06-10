package com.ftest.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test8 {
    public static void main(String[] args) {
        String a="a17283ee3d2d453ca3a3a468619af022\n" +
                "dc6bdd0abc684ec481a7e90c4680b571\n" +
                "7b778b86426b4d97a9035a73d83519eb\n" +
                "8eaca1f1d3ad4a2a8584321cba531b78\n" +
                "b5dfcf413f9c47c5826198c405fc1655\n" +
                "cb17f83100744038b5e2a7ff2bcc77e4\n" +
                "8a6b8e2d787e4e258db461598ed5aa7c\n" +
                "09429b5dc9d542a79835ea6275b61129\n" +
                "e3b037ff594949afb97eae6c601260c0\n" +
                "c2a75caf44404fe590af45694a0b3d29\n" +
                "d1b3f5060d3f465386bbdbf15e94969b\n" +
                "be9a23ed235744aeabb4c816ca4b3049\n" +
                "2602771579ee4069a46600c49df66e7f\n" +
                "f7ea1170aa104984917164d294085b10\n" +
                "dfd476d34e6b4884b3af0b63fb28169d\n" +
                "8833bb706b784f3784c5145edcc28bff\n" +
                "d6a8e3f6a0c04a9f8691afb72f8b503f\n" +
                "abe164ebe9a046b88fbd080deca9692b\n" +
                "3fb56ae0988042b5a44359ad6907710a\n" +
                "022098d8c95e4c0f85cfa3fa77cafce5\n" +
                "99c0cd8993364898a0e8b70123863de9\n" +
                "2b427b2d10714ede9fe361e644f2eedf\n" +
                "232b7063c8d94b699f754c3fc343a7ec\n" +
                "8334d8abd501476188faffb950a32f44\n" +
                "9c9dde7beab34dbcb70328a53ba1fe10\n" +
                "641f1f0bce3b45b287f2546083d56cda\n" +
                "959335f209ef46ed970b28e49a805508\n" +
                "64087a3ae2f64e36ae8a8f7d6a4fcb61";
        String[] split = a.split("\n");
        List<String> collect = Arrays.stream(split).map(
                it -> {
                    return it;
                }
        ).collect(Collectors.toList());
//        sql(collect);
        json2(collect);
    }

    public static void sql(List<String> collect){
        System.out.println("(");
        collect.stream().forEach(
                it->{
                    System.out.println(it+",");
                }
        );
        System.out.println(")");
    }

    public static void json1(List<Integer> collect){
        System.out.println("[");
        collect.stream().forEach(
                it->{
                    System.out.println("{\"dentalStoreId\":"+it+"},");
                }
        );
        System.out.println("]");
    }
    public static void json2(List<String> collect){
        System.out.println("[");
        collect.stream().forEach(
                it->{
                    System.out.println("\""+it+"\""+",");
                }
        );
        System.out.println("]");
    }
}
