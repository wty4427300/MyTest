package com.concurrent.mythread;

import java.util.concurrent.RecursiveTask;

public class FrokJion extends RecursiveTask<Long> {
    private Long start; //开始值
    private Long end; //结束值

    public static final Long critcal =10000L;//临界值

    public FrokJion(Long start,Long end){
        this.start=start;
        this.end=end;
    }

    //计算
    @Override
    protected Long compute() {
        //是否拆分完毕
        long length=end -start;
        if(length<critcal){
            Long sum=0L;
            for (Long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            //拆分任务
            Long middle=(start+end)/2;
            FrokJion frokJion=new FrokJion(start,middle);
            frokJion.fork();
            FrokJion frokJion1=new FrokJion(middle,end);
            frokJion1.fork();
            return frokJion.join()+frokJion1.join();
        }
    }
}
