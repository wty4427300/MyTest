package com.algorithm;

public class test875 {

    /**
     * @param piles 香蕉堆
     * @param h 用餐时间
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        //最慢每小时吃一个香蕉
        int low =1;
        int high=0;
        //获取最大速度
        for (int pile:piles){
            high=Math.max(high,pile);
        }
        int k=high;
        while (low<high){
            int speed=(high-low)/2+low;
            long time=this.getTime(piles,speed);
            if (time<=h){
                //能吃完则最小速度一定小于等于当前speed
                k=speed;
                //上限为speed
                high=speed;
            }else {
                //吃不完，则最小速度一定大于speed
                low=speed+1;
            }
        }
        return k;
    }

    public long getTime(int[] piles,int speed){
        //计算当前速度吃完香蕉的时间
        long time=0;
        for (int pile:piles){
            //如果有余数结果要+1
            int curTime=(pile+speed-1)/speed;
            time+=curTime;
        }
        return time;
    }
}
