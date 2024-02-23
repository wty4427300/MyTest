package com.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

import static com.kafka.KafkaConsumerAnalysis.isRunning;
import static com.kafka.KafkaConsumerAnalysis.topic;

public class ReBalanceListenTest {

    /**
     * 正常消费的时候异步提交，再均衡时同步提交
     */
    public void test() {
        Properties props = KafkaConsumerAnalysis.initConfig();
        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic), new ConsumerRebalanceListener() {
                @Override
                public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                    consumer.commitSync(currentOffsets);
                    currentOffsets.clear();
                }

                @Override
                public void onPartitionsAssigned(Collection<TopicPartition> collection) {

                }
            });
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                            //提交的是下一条要消费的消息的偏移量所以需要+1
                            new OffsetAndMetadata(record.offset() + 1));
                }
                consumer.commitAsync(currentOffsets, null);
            }
        }
    }

    public long getOffsetFromDB(TopicPartition tp) {
        return 0;
    }

    /**
     * 配合外部存储恢复消息消费偏移量
     */
    public void test1() {
        Properties props = KafkaConsumerAnalysis.initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic), new ConsumerRebalanceListener() {
                @Override
                public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                    //store offset in DB （storeOffsetToDB）
                }

                @Override
                public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                    for (TopicPartition tp : partitions) {
                        //从DB中读取消费位移
                        consumer.seek(tp, getOffsetFromDB(tp));
                    }
                }
            });
        }
    }


}
