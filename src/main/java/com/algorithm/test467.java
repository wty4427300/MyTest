package com.algorithm;

import java.math.BigInteger;

public class test467 {
    int N = 100010;
    int[][] trs = new int[26][N];
    int[] f = new int[N], max = new int[26];
    int n, ans;

    //寻找最低位的1
    int lowBit(int x) {
        return x & -x;
    }

    public void add(int[] tr, int x, int v) {
        for (int i = x; i <= n + 1; i += lowBit(i)) {
            tr[i] += v;
        }
    }

    public int query(int[] tr, int x) {
        //查询出s[i]开头的所有的子串长度和
        //树状数组的查询求和
        int ans = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            ans += tr[i];
        }
        return ans;
    }

    public int findSubstringInWraproundString(String p) {
        char[] cs = p.toCharArray();
        n = cs.length;
        for (int i = 0; i < n; i++) {
            //循环迭代字符串和'a'做减法
            //根据ascii编码c=0则说明cs[i]=a
            int c = cs[i] - 'a';
            if (i == 0) {
                //字符串开头的首字母一定是一个长度为1的子串
                f[i] = 1;
            } else {
                //这里一个是判断i-1是不是z
                int l = cs[i - 1] - 'a';
                //c == 0 && l == 25 说明是从cs[i-1]=z
                if ((c == 0 && l == 25) || l + 1 == c){
                    f[i] = f[i - 1] + 1;
                } else {
                    f[i] = 1;
                }
            }
            //我们使用一个长度为26的数组来记录s[i]字符串结尾的最长子串长度
            if (max[c] >= f[i]) {
                //如果当前长度f[i]小于max[c]说明当前子串已经被统计过了
                //直接跳出当前循环
                continue;
            }
            //那么trs[c]存的就是s[i]结尾的所有子串长度
            //cnt为统计的同结尾的子串数
            //总个数-已统计数=未统计数
            int cnt = f[i] - this.query(trs[c], f[i]);
            if (cnt == 0) {
                continue;
            }
            ans += cnt;
            //未统计存储
            this.add(trs[c], f[i], cnt);
            //记录最大子串长
            max[c] = f[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        BigInteger bi = new BigInteger(String.valueOf(-6));
        System.out.println(bi.toString(2));
    }
}
