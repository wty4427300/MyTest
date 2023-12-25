package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class test1276 {

    /**
     * 鸡兔同笼问题罢了
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(cheeseSlices * 2 - tomatoSlices / 2);
        return ans;
    }

}
