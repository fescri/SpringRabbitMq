package com.bbva.memento;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    // One Broker only
    /*@RabbitListener(queues = "queue1")
    public void processMessageClave1(String content) {
        System.out.println("MESSAGE FROM LISTENER WITH KEY (1): " + content);
    }

    @RabbitListener(queues = "queue2")
    public void processMessageClave2(String content) {
        System.out.println("MESSAGE FROM LISTENER WITH KEY (2): " + content);
    }*/
}
