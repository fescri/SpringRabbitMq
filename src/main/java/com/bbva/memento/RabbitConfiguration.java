package com.bbva.memento;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("192.168.99.100");
        connectionFactory.setPort(5001);
        //connectionFactory.setUsername("guest");
        //connectionFactory.setPassword("guest");

        return connectionFactory;
    }
/*
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
*/
    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean(name = "exchange")
    public String exchange() {
        return ("intercambio");
    }

    @Bean(name = "routingKey")
    public String routingKey() {
        return ("clave");
    }

    @Bean(name = "queue")
    public String queue() {
        return ("exampleManu");
    }
}
