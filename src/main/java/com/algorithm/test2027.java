package com.algorithm;

public class test2027 {
    public int minimumMoves(String s)  {
       int covered=-1,res=0;
       for(int i=0;i<s.length();i++){
           //连续三个X只需要一次转换
           if (s.charAt(i)=='X' && i>covered){
               res++;
               covered=i+2;
           }
       }
       return res;
    }
}
