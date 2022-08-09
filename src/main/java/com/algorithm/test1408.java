package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1408 {
    public List<String> stringMatching(String[] words) {
        List<String> result=new ArrayList<>();
        for (int i=0;i< words.length;i++){
            for (int j=0;j< words.length;j++){
                if (i!=j && words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        test1408 test1408=new test1408();
        String[] words={"ws","wsp","hs","hsd"};
        List<String> strings = test1408.stringMatching(words);
        System.out.println(strings);
    }
}
