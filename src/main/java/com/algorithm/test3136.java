package com.algorithm;

public class test3136 {
    public boolean isValid(String word) {
        if (word.length()<3){
            // 单词长度小于3，不符合要求
            return false;
        }
        // 标记是否包含元音字母
        boolean hasVowel = false;
        // 标记是否包含辅音字母
        boolean hasConsonant = false;
        // 遍历单词中的每个字符
        for (char c : word.toCharArray()) {
            // 如果字符是字母
            if (Character.isLetter(c)) {
                // 将字母转换为小写
                char ch = Character.toLowerCase(c);
                // 判断是否为元音字母
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    // 否则为辅音字母
                    hasConsonant = true;
                }
            // 如果字符不是数字
            } else if (!Character.isDigit(c)) {
                // 字符既不是字母也不是数字，不符合要求
                return false;
            }
        }
        // 判断是否同时包含元音字母和辅音字母
        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        test3136 test3136=new test3136();
        boolean valid = test3136.isValid("234Adas");
        System.out.println(valid);
    }

}
