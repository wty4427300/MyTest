package com.algorithm;

import com.alibaba.fastjson2.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class test3 {
    /**
     * 这种解法就是不断移动左指针减小窗口大小,每次的while都会得到一个完整的子串,记录每次的子串长度,如果下一次的更长就保留长度并返回
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //存储不重复的子串
        Set<Character> sub=new HashSet<>();
        int start=-1,end=0;
        for (int i=0;i<s.length();++i){
            if (i!=0){
                //左指针开始移动减小窗口范围
                sub.remove(s.charAt(i-1));
            }
            //开始遍历当前窗口,得到不重复的子串
            while (start+1<s.length() && !sub.contains(s.charAt(start+1))){
                sub.add(s.charAt(start+1));
                ++start;
            }
            end=Math.max(end,start-i+1);
        }
        return end;
    }

    public static int lengthOfLongestSubstring1(String s) {
        //存储字符串以及其索引
        HashMap<Character, Integer> map = new HashMap<>();
        //最大值,左指针
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            //遍历串
            char ch = s.charAt(end);
            //如果存在,start变成索引较大的
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            //不存在计算串长度并保留较大的,并存储
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        System.out.println(JSON.toJSONString(map));
        return max;
    }


    public static void main(String[] args) {
        int result = lengthOfLongestSubstring1("abcabcbb");
        System.out.println(result);
    }
}
