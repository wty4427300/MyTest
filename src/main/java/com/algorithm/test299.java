package com.algorithm;

public class test299 {

    public static String getHint(String secret, String guess) {
        //两个字符串是一样长的
        int length = secret.length();
        //a是公牛数字,b是奶牛数
        int a=0,b=0;
        int[] cnt1=new int[10],cnt2=new int[10];
        //遍历两个串
        for (int i=0;i<length;i++){
            //这里相当于做了hash计算出字符串对应的值
            int c1=secret.charAt(i)-'0',
                    c2=guess.charAt(i)-'0';
            if (c1==c2){
                //相等公牛加一
                a++;
            }else {
                //不相等打表,因为数字只有0-9所以字符串长度为10就够
                //对应的索引位每出现一次就加一做词频统计
                //每个数字出现次数较小的那个就是该数字的奶牛数,将所有的数相加就是所有的奶牛数
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }
        for (int i = 0; i < 10; i++) b += Math.min(cnt1[i], cnt2[i]);
        StringBuffer stringBuffer=new StringBuffer();
        return stringBuffer.append(a).append("A").append(b).append("B").toString();
    }

    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        String hint = getHint(secret, guess);
        System.out.println(hint);
    }
}
