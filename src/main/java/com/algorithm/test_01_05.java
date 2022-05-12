package com.algorithm;

public class test_01_05 {

    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();
        if (n-m==1){
            return this.oneInsert(second,first);
        }else if (m-n==1){
            return this.oneInsert(first,second);
        }else if (n==m){
            int i=0,j=0;
            while (i<m){
                if (first.charAt(i)!=second.charAt(i)){
                    j++;
                }
                i++;
            }
            if (j>1){
                return false;
            }else {
                return true;
            }
        }
        //不是一次编辑直接返回
        return false;
    }

    public boolean oneInsert(String shorter, String longer) {
        int length = shorter.length();
        int length1 = longer.length();
        int index = 0, index1 = 0;
        while (index < length && index1 < length1) {
            //如果字符串相同则长短字符串都加1,否则只是长的字符串加1
            //如果所以差大于1说明一次编辑无法达成直接返回结果即可
            if (shorter.charAt(index) == longer.charAt(index1)) {
                index++;
            }
            index1++;
            if (index1 - index > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean test1(String first,String second){
        int m = first.length();
        int i=0,j=0;
        while (i<m){
            if (first.charAt(i)!=second.charAt(i)){
                j++;
            }
            i++;
        }
        if (j>1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
