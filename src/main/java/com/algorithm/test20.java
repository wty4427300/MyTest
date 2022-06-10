package com.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class test20 {

    public boolean isValid(String s) {
        int n=s.length();
        if (n%2==1){
            return false;
        }
        Map<Character,Character> pairs=new HashMap<Character, Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                //右括号匹配
                //peek()返回第一个元素
                if (stack.isEmpty() || stack.peek()!=pairs.get(ch)){
                    return false;
                }
                //匹配完毕，pop()弹出一个元素
                stack.pop();
            }else {
                //左括号压栈
                stack.push(ch);
            }
        }
        //全部匹配空栈
        return stack.isEmpty();
    }
}
