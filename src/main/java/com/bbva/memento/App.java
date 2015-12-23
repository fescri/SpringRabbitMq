package com.bbva.memento;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App  {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);

        //AmqpTemplate template = context.getBean(AmqpTemplate.class);

        RabbitTemplate template = context.getBean(RabbitTemplate.class);

        template.setExchange(context.getBean("exchange", String.class));
        template.setRoutingKey(context.getBean("routingKey", String.class));

        template.convertAndSend("mensaje enviado");

        String message = (String) template.receiveAndConvert(context.getBean("queue", String.class));

        System.out.println("MESSAGE RECEIVED: " + message);
    }
}
