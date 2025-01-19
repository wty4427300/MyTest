package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, true);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            mp.remove(moveFrom[i]);
            mp.put(moveTo[i], true);
        }
        for (Map.Entry<Integer, Boolean> entry : mp.entrySet()) {
            ans.add(entry.getKey());
        }
        ans.sort(null);
        return ans;
    }
}
