package com.ftest.flinkTest;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.Random;



//自定义的数据源
public class MySource extends RichParallelSourceFunction<Tuple2<String,Integer>> {
    //全局的标志位表示数据源是否正常运行
    private volatile boolean isRunning=true;
    @Override
    public void run(SourceContext<Tuple2<String, Integer>> ctx) throws Exception {
        Random random = new Random();
        long time=System.currentTimeMillis();
        while (isRunning){
                ctx.collectWithTimestamp(new Tuple2<>("数字",random.nextInt()),time);
        }
    }


    //取消数据的生成
    @Override
    public void cancel() {
        isRunning=false;
    }
}
