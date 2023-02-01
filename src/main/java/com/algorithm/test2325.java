package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class test2325 {
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map=new HashMap<>();
        char cur='a';
        //对照表
        for (int i=0;i<key.length();i++){
            char c=key.charAt(i);
            if (c!=' '&&  !map.containsKey(c)){
                map.put(c,cur);
                cur++;
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<message.length();i++){
            char c=message.charAt(i);
            if(c!=' '){
                c=map.get(c);
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
