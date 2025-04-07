package com.oteller.example.service.notification.service;


import com.oteller.example.service.notification.config.AbcLoggerDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.topics.test.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        System.out.println("Kafkadan Test Mesaj: " + message);
    }

    @KafkaListener(topics = "${spring.kafka.topics.reservation.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeReservation(String message) {
        System.out.println("Kafkadan Reservation Mesaj: " + message);
    }

    @KafkaListener(topics = "${spring.kafka.topics.abc-logger.name}", containerFactory = "kafkaListenerContainerFactoryByAbcLoggerDto")
    public void consumeByAbcLoggerDto(ConsumerRecord<String, AbcLoggerDto> consumerRecord) {
        AbcLoggerDto dto = consumerRecord.value();
        logger.info("service : "+dto.getMicroServiceName()+"  AbcLogger Mesaj: "+dto.getMessage());
    }
}
