package com.algorithm;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    private String[] arr;
    /**
     * 指针从1开始,所以index=0不存储数据,
     * 存储n个数据需要n+1的空间
     */
    private int ptr;

    public OrderedStream(int n) {
        this.arr = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey]=value;
        List<String> result=new ArrayList<>();
        while (ptr<arr.length && arr[ptr]!=null){
            result.add(arr[ptr]);
            ++ptr;
        }
        return result;
    }
}

public class test1656 {
}
