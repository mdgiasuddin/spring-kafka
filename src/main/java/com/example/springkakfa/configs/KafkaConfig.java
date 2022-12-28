package com.example.springkakfa.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.example.springkakfa.constants.AppConstant.*;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicString() {
        return TopicBuilder.name(TOPIC_STRING)
                .build();
    }

    @Bean
    public NewTopic topicGreeting() {
        return TopicBuilder.name(TOPIC_GREETING)
                .build();
    }

    @Bean
    public NewTopic topicStudent() {
        return TopicBuilder.name(TOPIC_STUDENT)
                .build();
    }

}
