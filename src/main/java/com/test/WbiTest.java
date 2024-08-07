package com.test;

import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.*;

/**
 * todo url的拼接有点问题，暂时不想改
 */
public class WbiTest {
    private static final int[] mixinKeyEncTab = new int[]{
            46, 47, 18, 2, 53, 8, 23, 32, 15, 50, 10, 31, 58, 3, 45, 35, 27, 43, 5, 49,
            33, 9, 42, 19, 29, 28, 14, 39, 12, 38, 41, 13, 37, 48, 7, 16, 24, 55, 40,
            61, 26, 17, 0, 1, 60, 51, 30, 4, 22, 25, 54, 21, 56, 59, 6, 63, 57, 62, 11,
            36, 20, 34, 44, 52
    };

    public static String getMixinKey(String imgKey, String subKey) {
        String s = imgKey + subKey;
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            key.append(s.charAt(mixinKeyEncTab[i]));
        }
        return key.toString();
    }

    public static void main(String[] args) {
        String imgKey = "7cd084941338484aae1ad9425b84077c";
        String subKey = "4932caff0ff746eab6f01bf08b70ac45";
        String mixinKey = getMixinKey(imgKey, subKey);
        System.out.println(mixinKey);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("mid", "38285518");
        map.put("wts", System.currentTimeMillis() / 1000);
        map.put("Referer", "https://api.bilibili.com/x/space/wbi/acc/info?");
        StringJoiner param = new StringJoiner("&");
        //排序 + 拼接字符串
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> param.add(entry.getKey() + "=" + URLUtil.encode(entry.getValue().toString())));
        String s = param + mixinKey;
        String wbiSign = SecureUtil.md5(s);
        System.out.println(wbiSign);
        String finalParam = param + "&w_rid=" + wbiSign;
        System.out.println(finalParam);
    }
}