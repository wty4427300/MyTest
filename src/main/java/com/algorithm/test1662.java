package com.algorithm;

import java.util.Arrays;

public class test1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return Arrays.asList(word1).toString().replace(", ", "").equals(Arrays.asList(word2).toString().replace(", ", ""));
    }
}
