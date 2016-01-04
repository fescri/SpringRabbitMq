package com.bbva.memento;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App  {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);

        RabbitTemplate template = context.getBean(RabbitTemplate.class);

        template.setExchange(context.getBean("exchange", String.class));

        template.convertAndSend(context.getBean("routingKey", String.class) + "1", "Message queued with key 1");
        template.convertAndSend(context.getBean("routingKey", String.class) + "2", "Message queued with key 2");

        Thread.sleep(60000);

        System.exit(0);

    }
}
