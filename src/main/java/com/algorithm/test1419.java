package com.algorithm;

public class test1419 {

    private static final char[] previous = new char['s'];

    static {
        char[] s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++) {
            previous[s[i]] = s[i - 1];
        }
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] cnt = new char['s'];
        for (char c : croakOfFrogs.toCharArray()) {
            char pre = previous[c];
            if (cnt[pre] > 0) {
                cnt[pre]--;
            } else if (c != 'c') {
                return -1;
            }
            cnt[c]++;
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0) {
            return -1;
        }
        return cnt['k'];
    }

    public static void main(String[] args) {
        test1419 test1419 = new test1419();
        int ans = test1419.minNumberOfFrogs("crcoakroak");
        System.out.println(ans);
    }
}
