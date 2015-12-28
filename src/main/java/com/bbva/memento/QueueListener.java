package com.bbva.memento;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @RabbitListener(queues = "exampleManu")
    public void processMessageClave1(String content) {
        System.out.println("MESSAGE FROM LISTENER CON CLAVE (1): " + content);
    }

    @RabbitListener(queues = "example2Manu")
    public void processMessageClave2(String content) {
        System.out.println("MESSAGE FROM LISTENER CON CLAVE (2): " + content);
    }
}
