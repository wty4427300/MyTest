package com.algorithm;

public class test3330 {
    public int possibleStringCount(String word) {
        int ans=1;
        for(int i=1;i<word.length();i++){
            if (word.charAt(i-1)==word.charAt(i)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        test3330 solution = new test3330();
        
        // 测试用例 1
        String word1 = "aa";
        int result1 = solution.possibleStringCount(word1);
        System.out.println("Test 1 - Input: " + word1 + ", Result: " + result1);
        
        // 测试用例 2
        String word2 = "ab";
        int result2 = solution.possibleStringCount(word2);
        System.out.println("Test 2 - Input: " + word2 + ", Result: " + result2);
        
        // 测试用例 3
        String word3 = "abc";
        int result3 = solution.possibleStringCount(word3);
        System.out.println("Test 3 - Input: " + word3 + ", Result: " + result3);
        
        // 测试用例 4
        String word4 = "aabb";
        int result4 = solution.possibleStringCount(word4);
        System.out.println("Test 4 - Input: " + word4 + ", Result: " + result4);
    }
}
 