package com.example.springkakfa.consumers;

import com.example.springkakfa.models.Greeting;
import com.example.springkakfa.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.example.springkakfa.constants.AppConstant.*;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = TOPIC_STRING, groupId = GROUP_ID)
    public void consume(String message){
        logger.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = TOPIC_GREETING, groupId = GROUP_ID)
    public void consume(Greeting greeting){
        logger.info(String.format("Message received -> %s", greeting));
    }

    @KafkaListener(topics = TOPIC_STUDENT, groupId = GROUP_ID)
    public void consume(Student student){
        logger.info(String.format("Message received -> %s", student));
    }
}
