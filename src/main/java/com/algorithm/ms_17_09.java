package com.algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ms_17_09 {
    public int getKthMagicNumber(int k) {
        int[] factors={3,5,7};
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> heap=new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int ugly=0;
        for (int i=0;i<k;i++){
            long curr=heap.poll();
            ugly=(int)curr;
            for (int factor:factors){
                long next=curr*factor;
                if (set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
