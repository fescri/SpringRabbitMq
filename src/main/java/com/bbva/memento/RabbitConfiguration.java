package com.bbva.memento;

import com.rabbitmq.client.SaslConfig;
import com.rabbitmq.client.SaslMechanism;
import com.rabbitmq.client.impl.ExternalMechanism;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableRabbit
@ComponentScan(basePackages = "com.bbva.memento")
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() throws Exception {

        // Rabbit SSL Conection
        RabbitConnectionFactoryBean factoryBean = new RabbitConnectionFactoryBean();
        factoryBean.setUseSSL(true);
        factoryBean.setSslPropertiesLocation(new ClassPathResource("ssl.properties"));

        SaslConfig saslConfig = new SaslConfig() {
            public SaslMechanism getSaslMechanism(String[] strings) {
                SaslMechanism mechanism = new ExternalMechanism();
                return mechanism;
            }
        };
        factoryBean.setSaslConfig(saslConfig);

        factoryBean.afterPropertiesSet();

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(factoryBean.getObject());

        // set of Addresses with rabbit federated brokers included
        connectionFactory.setAddresses("172.17.0.1:5673,172.17.0.2:5673");

        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() throws Exception {

        return new RabbitTemplate(connectionFactory());
    }

    @Bean(name = "exchange")
    public String exchange() {
        return ("federate.exchange");
    }

    @Bean(name = "routingKey")
    public String routingKey() {
        return ("key");
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() throws Exception {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
}
