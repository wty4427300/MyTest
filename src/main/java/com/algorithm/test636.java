package com.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class test636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Deque<Integer> deque=new ArrayDeque<>();
        int cur=-1;
        for (String log:logs){
            String[] values=log.split(":");
            //函数id
            int idx=Integer.parseInt(values[0]);
            int ts=Integer.parseInt(values[2]);
            String op=values[1];
            if (op.equals("start")){
                if (!deque.isEmpty()){
                    //记录入栈时间
                    ans[deque.peekLast()]+=ts-cur;
                }
                //入栈顶
                deque.addLast(idx);
                cur=ts;
            }else {
                int func= deque.pollLast();
                ans[func]+=ts-cur+1;
                cur=ts+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] values={"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        List<String> logs = Arrays.stream(values).collect(Collectors.toList());
        test636 test636=new test636();
        test636.exclusiveTime(n,logs);
    }
}
