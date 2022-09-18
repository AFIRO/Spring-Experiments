package com.zetta.springexperiments.services;

import com.zetta.springexperiments.events.RabbitReceiver;
import com.zetta.springexperiments.events.TestEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EventService {
    private final AmqpTemplate amqpTemplate;
    private final RabbitReceiver receiver;

    public EventService(final RabbitTemplate amqpTemplate, RabbitReceiver receiver) {
        this.amqpTemplate = amqpTemplate;
        this.receiver = receiver;
    }

    public void sendMessage(TestEvent event) throws InterruptedException {
        amqpTemplate.convertAndSend("test_exchange","test_routingKey", event);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
