package com.test;

import com.algorithm.ArrayQueue;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
class User {
    private Long id;
    private String name;
}

public class test12 {
    public boolean test(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else {
                char c = stack.peek();
                if (c == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (c == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if (c == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        test12 test12 = new test12();
        String s = "()[]{}";
        boolean t1 = test12.test(s);
        System.out.println(t1);
        List<User> userList = new ArrayList<>();
        userList.stream().collect(Collectors.toMap(User::getId, user -> user));
    }
}
