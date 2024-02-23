package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class KafkaConsumerAnalysis {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "quickstart-events";
    public static final String groupId = "group.demo";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static Properties initConfig() {
        Properties props = new Properties();
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("bootstrap.servers", brokerList);
        props.put("group.id", groupId);
        props.put("client.id", "consumer.client.id.demo");
        //开启拦截器
        props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG,
                ConsumerInterceptorTest.class.getName());
        return props;
    }

    /**
     * 普通消费一下
     */
    public void test1() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic()
                            + ", partition = " + record.partition()
                            + ", offset = " + record.offset());
                    System.out.println("key = " + record.key()
                            + ", value = " + record.value());
                    //do something to process record.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费固定topic,partition的消息
     * 并查看一些偏移量属性
     */
    public void test2() {
        Properties props = initConfig();
        TopicPartition tp = new TopicPartition(topic, 0);
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.assign(List.of(tp));
            long lastConsumedOffset = -1;//当前消费到的位移
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                if (records.isEmpty()) {
                    break;
                }
                List<ConsumerRecord<String, String>> recordList = records.records(tp);
                lastConsumedOffset = recordList.get(recordList.size() - 1).offset();
                //同步提交消费位移
                consumer.commitAsync();
            }
            System.out.println("consumed offset is " + lastConsumedOffset);
            Set<TopicPartition> set = new HashSet<>();
            set.add(tp);
            Map<TopicPartition, OffsetAndMetadata> committed = consumer.committed(set);
            OffsetAndMetadata offsetAndMetadata = committed.get(tp);
            if (ObjectUtils.isNotEmpty(offsetAndMetadata)) {
                System.out.println("committed offset is " + offsetAndMetadata.offset());
                long position = consumer.position(tp);
                System.out.println("the offset of the next record is " + position);
            }
        }
    }

    /**
     * 同步提交偏移量
     */
    public void test3() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic()
                            + ", partition = " + record.partition()
                            + ", offset = " + record.offset());
                    System.out.println("key = " + record.key()
                            + ", value = " + record.value());
                }
                consumer.commitSync();
            }
        }
    }

    /**
     * 批量同步提交偏移量
     */
    public void test4() {
        final int batchSize = 200;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    buffer.add(record);
                }
                if (buffer.size() >= batchSize) {
                    consumer.commitSync();
                    buffer.clear();
                }
            }
        }
    }

    /**
     * 单次提交
     * 需要提交的是下一条要消费的消息的 offset，即 lastConsumedOffset + 1。
     * 这样做可以确保下一次消费者启动时从正确的位置开始消费消息。
     */
    public void test5() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    //do some logical processing.
                    long offset = record.offset();
                    TopicPartition partition =
                            new TopicPartition(record.topic(), record.partition());
                    consumer.commitSync(Collections
                            .singletonMap(partition, new OffsetAndMetadata(offset + 1)));
                }
            }
        }
    }

    /**
     * partition粒度的单次提交
     */
    public void test6() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (TopicPartition partition : records.partitions()) {
                    List<ConsumerRecord<String, String>> partitionRecords =
                            records.records(partition);
                    for (ConsumerRecord<String, String> record : partitionRecords) {
                        System.out.println("topic = " + record.topic()
                                + ", partition = " + record.partition()
                                + ", offset = " + record.offset());
                        System.out.println("key = " + record.key()
                                + ", value = " + record.value());
                    }
                    long lastConsumedOffset = partitionRecords
                            .get(partitionRecords.size() - 1).offset();
                    consumer.commitSync(Collections.singletonMap(partition,
                            new OffsetAndMetadata(lastConsumedOffset + 1)));
                }
            }
        }
    }

    /**
     * 异步提交,多次异步提交其中一次发生异常,导致offset回滚导致重复消费
     */
    public void test7() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic()
                            + ", partition = " + record.partition()
                            + ", offset = " + record.offset());
                    System.out.println("key = " + record.key()
                            + ", value = " + record.value());
                }
                //异步提交
                consumer.commitAsync((offsets, exception) -> {
                    if (exception == null) {
                        System.out.println(offsets);
                    } else {
                        log.error("fail to commit offsets {}", offsets, exception);
                    }
                });
            }
        }
    }

    public void test8() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic()
                            + ", partition = " + record.partition()
                            + ", offset = " + record.offset());
                    System.out.println("key = " + record.key()
                            + ", value = " + record.value());
                }
                //异步提交
                consumer.commitAsync((offsets, exception) -> {
                    if (exception == null) {
                        System.out.println(offsets);
                    } else {
                        log.error("fail to commit offsets {}", offsets, exception);
                    }
                });
            }
        }
    }

    /**
     * 一个相对完整的消费逻辑
     */
    public void test9() {
        Properties props = initConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            try {
                while (isRunning.get()) {
                    //consumer.poll(***)
                    //process the record.
                    //commit offset.
                }
            } catch (WakeupException e) {
                // ignore the error
            } catch (Exception e) {
                // do some logic process.
            }
        }
    }

    /**
     * 使用seek()从特定位置开始消费,比如紧接着上次的消费位移
     * seek() 方法只能重置消费者分配到的分区的消费位置，而分区的分配是在 poll() 方法的调用过程中实现的。
     * 也就是说，在执行 seek() 方法之前需要先执行一次 poll() 方法，等到分配到分区之后才可以重置消费位置。
     * 如果消费者未分配到partition就调用seek()会报IllegalStateException错误
     */
    public void test10() {
        Properties props = initConfig();
        //这里自动调用close
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            try {
                while (isRunning.get()) {
                    //需要先调用一次poll,Duration不能为0
                    Set<TopicPartition> assignment = new HashSet<>();
                    while (assignment.isEmpty()) {
                        //如果不为0，则说明已经成功分配到了分区
                        consumer.poll(Duration.ofMillis(100));
                        assignment = consumer.assignment();
                    }
                    for (TopicPartition tp : assignment) {
                        consumer.seek(tp, 10);
                    }
                    while (true) {
                        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                        //consume the record.
                    }
                }
            } catch (WakeupException e) {
                // ignore the error
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }

    /**
     * 从上次的消费位置开始消费
     * endOffsets
     * 对应的就有beginningOffsets,但它不会一直是0,
     * 因为日志清理会清除老的数据
     * public void seekToBeginning(Collection<TopicPartition> partitions)
     * public void seekToEnd(Collection<TopicPartition> partitions)
     * 也可以通过kafka提供的这两个方法从开头或者结尾消费,更加简洁
     * public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(
     * Map<TopicPartition, Long> timestampsToSearch)
     * public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(
     * Map<TopicPartition, Long> timestampsToSearch,
     * Duration timeout)
     * 通过这些方法可以追溯到具体的时间开始消费,map key为分区,value为时间戳
     */
    public void test11() {
        Properties props = initConfig();
        //这里自动调用close
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            try {
                while (isRunning.get()) {
                    //需要先调用一次poll,Duration不能为0
                    Set<TopicPartition> assignment = new HashSet<>();
                    while (assignment.isEmpty()) {
                        //如果不为0，则说明已经成功分配到了分区
                        consumer.poll(Duration.ofMillis(100));
                        assignment = consumer.assignment();
                    }
                    Map<TopicPartition, Long> offsets = consumer.endOffsets(assignment);
                    for (TopicPartition tp : assignment) {
                        consumer.seek(tp, offsets.get(tp));
                    }
                    while (true) {
                        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                        //consume the record.
                    }
                }
            } catch (WakeupException e) {
                // ignore the error
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }

    public static void main(String[] args) {
        KafkaConsumerAnalysis kafkaConsumer = new KafkaConsumerAnalysis();
        kafkaConsumer.test2();
    }
}
