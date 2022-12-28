package com.example.springkakfa.controllers;

import com.example.springkakfa.models.Greeting;
import com.example.springkakfa.models.Student;
import com.example.springkakfa.producers.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    @GetMapping("/publish/string")
    public ResponseEntity<String> sendStringMessage() {
        kafkaProducer.sendMessage("Welcome to Kafka!");

        return ResponseEntity.ok("Message sent successfully!");
    }

    @GetMapping("/publish/greeting")
    public ResponseEntity<String> sendGreetingMessage() {
        kafkaProducer.sendMessage(new Greeting("Greetings", "Welcome to spring kafka"));

        return ResponseEntity.ok("Message sent successfully!");
    }

    @GetMapping("/publish/student")
    public ResponseEntity<String> sendStudentMessage() {
        kafkaProducer.sendMessage(new Student("Giash Uddin", 123456, 345678));

        return ResponseEntity.ok("Message sent successfully!");
    }

}
