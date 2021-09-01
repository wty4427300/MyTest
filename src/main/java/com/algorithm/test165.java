package com.algorithm;

public class test165 {
    public int compareVersion(String v1, String v2) {
        String[] sv1= v1.split("\\.");
        String[] sv2= v2.split("\\.");
        int n=sv1.length;
        int m=sv2.length;
        int i=0,j=0;
        while (i<n||j<m){
            int a=0,b=0;
            if (i<n){
                a=Integer.parseInt(sv1[i++]);
            }
            if (j<m){
                b=Integer.parseInt(sv2[j++]);
            }
            if (a!=b){
                return a>b?1:-1;
            }
        }
        return 0;
    }
}
