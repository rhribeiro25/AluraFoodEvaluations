package br.com.alurafood.evaluations.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return  rabbitTemplate;
    }

    @Bean
    public Queue queuePaymentsCreated() {
        return QueueBuilder
                .nonDurable("alura-food.payments-ms.payments-created.evaluations-ms")
                .deadLetterExchange("payments.created.evaluations.dlx")
                .build();
    }

    @Bean
    public Queue dlqQueuePaymentsCreated() {
        return QueueBuilder
                .nonDurable("alura-food.payments-ms.payments-created.evaluations-ms.dlq")
                .build();
    }

    @Bean
    public FanoutExchange paymentsFanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange("payments.created.ex")
                .build();
    }

    @Bean
    public FanoutExchange paymentsDeadLetterExchange() {
        return ExchangeBuilder
                .fanoutExchange("payments.created.evaluations.dlx")
                .build();
    }

    @Bean
    public Binding bindPaymentsevaluations() {
        return BindingBuilder
                .bind(queuePaymentsCreated())
                .to(paymentsFanoutExchange());
    }

    @Bean
    public Binding bindDlxPaymentsevaluations() {
        return BindingBuilder
                .bind(dlqQueuePaymentsCreated())
                .to(paymentsDeadLetterExchange());
    }

    @Bean
    public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

}