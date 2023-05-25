package com.ftest.effectivenote;

import java.util.List;
import java.util.Objects;

/**
 * 对象初始化的时候,注入资源
 */
public class SpellChecker {

    private final String Dictionary;

    public SpellChecker(String dictionary) {
        this.Dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){
        return false;
    }

    public List<String> suggestions(String typo){
        return null;
    }
}
