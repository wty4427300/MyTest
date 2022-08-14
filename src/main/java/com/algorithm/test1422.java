package com.algorithm;

public class test1422 {
    public int maxScore(String s) {
        int length = s.length();
        //先计算首个分割点左子串的得分
        int cur = s.charAt(0) == '0' ? 1 : 0;
        //计算首个分割点右子串的得分
        for (int i=1;i<length;i++){
            //如果是'1'加一分
            cur+= s.charAt(i)-'0';
        }
        int ans=cur;
        //第二个分割点开始
        //因为左右子串都不能为空,所以最多遍历到length-1的位置,
        //此时右子串为最后一位
        for (int i=1;i<length-1;i++){
            cur+=s.charAt(i)=='0'?1:-1;
            ans=Math.max(ans,cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="00111";
        test1422 test1422=new test1422();
        int score = test1422.maxScore(s);
        System.out.println(score);
    }
}
