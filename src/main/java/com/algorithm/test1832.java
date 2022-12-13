package com.algorithm;

public class test1832 {

    public boolean checkIfPangram(String sentence) {
        int[] tab=new int[26];
        for (int i=0;i<sentence.length();i++){
            tab[sentence.charAt(i)-'a']++;
        }
        for (int i:tab){
            if (i<1){
                return false;
            }
        }
        return true;
    }

}
