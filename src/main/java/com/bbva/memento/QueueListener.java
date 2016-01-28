package com.bbva.memento;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @RabbitListener(queues = "memento.events.queue")
    public void processMessage(String content) {
        System.out.println("MESSAGE CONSUMED: " + content);
    }
}
