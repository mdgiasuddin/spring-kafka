package com.example.springkakfa.producers;

import com.example.springkakfa.models.Greeting;
import com.example.springkakfa.models.Student;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.example.springkakfa.constants.AppConstant.*;

@Service
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Student> studentKafkaTemplate;

    public void sendMessage(String data) {
        logger.info(String.format("Message sent -> %s", data));

        Message<String> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_STRING)
                .build();

        stringKafkaTemplate.send(message);
    }

    public void sendMessage(Greeting greeting) {
        logger.info(String.format("Message sent -> %s", greeting));

        Message<Greeting> message = MessageBuilder
                .withPayload(greeting)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_GREETING)
                .build();

        greetingKafkaTemplate.send(message);
    }

    public void sendMessage(Student student) {
        logger.info(String.format("Message sent -> %s", student));

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_STUDENT)
                .build();

        studentKafkaTemplate.send(message);
    }

}
