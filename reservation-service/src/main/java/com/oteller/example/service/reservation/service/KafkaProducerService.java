package com.oteller.example.service.reservation.service;

import com.oteller.example.service.reservation.config.AbcLoggerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateByString;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplateByObject;
    @Autowired
    private KafkaTemplate<String, AbcLoggerDto> kafkaTemplateByAbcLoggerDto;


    @Value("${spring.kafka.topics.test.name}")
    private String testTopic = "test-topic";
    @Value("${spring.kafka.topics.reservation.name}")
    private  String reservationTopic = "reservation-topic";
    @Value("${spring.kafka.topics.abc-logger.name}")
    private  String abcLoggerTopic = "abc-logger-topic";

    public void sendTestTopic(String message) {
        kafkaTemplateByString.send(testTopic, message);
    }

    public void sendReservationTopic(String message) {
        kafkaTemplateByObject.send(reservationTopic, message);
    }

    public void sendAbcLogger(AbcLoggerDto message) {
        kafkaTemplateByAbcLoggerDto.send(abcLoggerTopic, message);
    }
}
