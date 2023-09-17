package com.johndeere.machine_tracking;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        String topic = "machine-data-topic";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Sample message in JSON format with an actual timestamp
        String sampleMessage = "{\"sessionId\": \"asfpa-asdf-asdfa\", \"machineId\": \"2343-asdf-fads\", \"startAt\": \"2023-09-16T12:00:00Z\"}";

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, sampleMessage);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    System.out.println("Message sent successfully: " + recordMetadata.toString());
                } else {
                    System.err.println("Error sending message: " + e.getMessage());
                }
            }
        });

        producer.close();
    }
}
