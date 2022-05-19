package com.algorithm;

public class test668 {

    public int findKthNumber(int m, int n, int k) {
        //乘法表的首尾分别是1和m*n,这样就是表示出了整个乘法表的区间
        //有区间就可以使用二分法进行查找
        int left = 1, right = m * n;
        //当left小于right就说明区间还没有判断完成,还需要继续查找
        while (left < right) {
            //取一个中间数x
            int x = left + (right - left) / 2;
            //首先计算x的m,5/3=1,1*3=3,也就是说至少有一整行小于5,然后一行是3个,所以至少有三个数小于5.
            int count = x / n * n;
            //因为不能整除所以下一行可能还有小于5的数
            // i=x/n+1=2就是下一行的行数
            for (int i = x / n + 1; i <= m; i++) {
                //从新的一行开始商>1的都是小于等于5的数可以被统计
                //这里只加商所以当x/i小于1的时候就是+0.
                count += x / i;
            }
            //当代码执行到这里就已经统计完了小于x的所有数字
            if (count >= k) {
                //如果count大于等于k说明索引k的数字在left-x的范围内
                right = x;
            } else {
                //如果count小于k,则说明1+x<=array[k]<m*x
                left = x + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        test668 test668 = new test668();
        int kthNumber = test668.findKthNumber(3, 3, 8);
        System.out.println(kthNumber);
    }
}
