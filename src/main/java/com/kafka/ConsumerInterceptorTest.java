package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 自定义的消费者拦截器
 * 实现一个消息ttl
 * 需要再props里面注册配置，才会被调用
 */
public class ConsumerInterceptorTest implements
        ConsumerInterceptor<String, String> {

    private static final long EXPIRE_INTERVAL = 10 * 1000;

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> consumerRecords) {
        long now = System.currentTimeMillis();
        Map<TopicPartition, List<ConsumerRecord<String, String>>> newRecords
                = new HashMap<>();
        for (TopicPartition tp : consumerRecords.partitions()) {
            List<ConsumerRecord<String, String>> records = consumerRecords.records(tp);
            List<ConsumerRecord<String, String>> newTpRecords = new ArrayList<>();
            for (ConsumerRecord<String, String> record : records) {
                if (now - record.timestamp() < EXPIRE_INTERVAL) {
                    newTpRecords.add(record);
                }
            }
            if (!newTpRecords.isEmpty()) {
                newRecords.put(tp, newTpRecords);
            }
        }
        return new ConsumerRecords<>(newRecords);
    }

    /**
     * 打印提交的偏移量
     */
    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        map.forEach((tp, offset) ->
                System.out.println(tp + ":" + offset.offset()));
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
