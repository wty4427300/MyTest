package com.algorithm;

import java.util.Map;

public class test676 {
    public static void main(String[] args) {

    }
}

class MagicDictionary {

    private String[] words;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : words) {
            //长度相同才有可能替换。
            if (word.length() != searchWord.length()) {
                continue;
            }
            //只替换一个就可以相同
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}


