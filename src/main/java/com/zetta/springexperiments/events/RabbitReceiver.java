package com.zetta.springexperiments.events;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class RabbitReceiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(TestEvent event) {
        System.out.println("Received <" + event.getId() + " : " + event.getPayload()  + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
