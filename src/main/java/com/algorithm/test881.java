package com.algorithm;

import java.util.Arrays;

public class test881 {
    //人的体重数组和船的最大限重
    public int numRescueBoats(int[] people, int limit) {
        int ans=0;
        //体重进行排序
        Arrays.sort(people);
        //双指针分别指向最轻的和最重的
        int light=0;
        int heavy=people.length-1;
        while (light<=heavy){
            //最重的人和最轻的人加起来是否超过了限制
            if (people[light]+people[heavy]<=limit){
                light++;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }
}
