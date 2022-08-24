package com.algorithm;

public class test1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int j = 0; j < s.length; j++) {
            if (s[j].length() >= searchWord.length()) {
                int cnt = 0;
                for (int i = 0; i < searchWord.length(); i++) {
                    if (s[j].charAt(i) == searchWord.charAt(i)) {
                        cnt++;
                    }
                }
                //单词下标从1开始，所以这里要+1
                if (cnt == searchWord.length()) {
                    return j+1;
                }
            }
        }
        return -1;
    }
}
