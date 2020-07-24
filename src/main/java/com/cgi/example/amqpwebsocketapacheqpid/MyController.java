package com.cgi.example.amqpwebsocketapacheqpid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyController {

    private final IntegrationFlow sendFlow;

    @Autowired
    public MyController(IntegrationFlow sendFlow) {
        this.sendFlow = sendFlow;
    }

    void sendMessage(String message) {
        sendFlow.getInputChannel().send(MessageBuilder.withPayload(message).build());
    }
}
