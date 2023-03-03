package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }

    public static void main(String[] args) {
        String[] a = {"wano", "wano", "wano", "wano"};
        test1487 test1487 = new test1487();
        String[] folderNames = test1487.getFolderNames(a);
        System.out.println(Arrays.toString(folderNames));
    }
}
