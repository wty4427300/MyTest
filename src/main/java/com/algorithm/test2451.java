package com.algorithm;

import java.util.Arrays;

public class test2451 {
    public String oddString(String[] words) {
        int[] diff0 = this.get(words[0]);
        int[] diff1 = this.get(words[1]);
        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, this.get(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
    }

    public int[] get(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }
}
