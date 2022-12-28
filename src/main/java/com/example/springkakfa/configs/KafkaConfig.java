package com.example.springkakfa.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.example.springkakfa.constants.AppConstant.TOPIC_STUDENT;
import static com.example.springkakfa.constants.AppConstant.TOPIC_GREETING;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicGreeting() {
        return TopicBuilder.name(TOPIC_GREETING)
                .build();
    }

    @Bean
    public NewTopic topicObject() {
        return TopicBuilder.name(TOPIC_STUDENT)
                .build();
    }

}
