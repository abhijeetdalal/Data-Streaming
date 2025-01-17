package com.data.stream.generator;

import com.data.stream.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
@Slf4j
public class GeneratorWebSocketHandler extends AbstractWebSocketHandler {

    private final KafkaProducer kafkaProducer;

    public GeneratorWebSocketHandler(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        System.out.println("---> To be Sent: " + message.getPayload());
        kafkaProducer.send("This is a sample message");
    }
}
