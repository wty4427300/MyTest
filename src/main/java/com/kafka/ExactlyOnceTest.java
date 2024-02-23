package com.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static com.kafka.KafkaConsumerAnalysis.*;

/**
 * 有且仅有一次
 */
public class ExactlyOnceTest {

    public static Properties initExactlyOnceConfig() {
        Properties props = new Properties();
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("bootstrap.servers", brokerList);
        props.put("group.id", groupId);
        //开启事务
        props.put("transactional.id", "exactly-once-producer");
        //关闭自动提交
        props.put("enable.auto.commit", "false");
        return props;
    }

    /**
     * 一个简单的 Kafka 生产者，它使用了事务，并在每次发送消息时都开启了一个事务。如果发送过程中出现异常，则会回滚事务，确保消息不会丢失。
     */
    public void ExactlyOnceProducer() {
        Properties props = initExactlyOnceConfig();
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            producer.initTransactions();
            producer.beginTransaction();
            for (int i = 0; i < 10; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "key-" + i, "value-" + i);
                producer.send(record);
            }
            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            // 处理异常
            e.printStackTrace();
        }
    }


    /**
     * 一个简单的 Kafka 消费者，它禁用了自动提交偏移量，每处理完一条消息后都手动提交了偏移量事务，以确保消息的精确一次语义。
     */
    public void ExactlyOnceConsumer() {
        Properties props = initExactlyOnceConfig();
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(List.of(topic));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    // 处理消息
                    System.out.println("Received message: " + record.value());

                    // 处理完消息后，提交偏移量事务
                    consumer.commitSync(Collections.singletonMap(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1)));
                }
            }
        }

    }
}
