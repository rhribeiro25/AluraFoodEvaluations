package br.com.alurafood.evaluations.rabbitmq;

import br.com.alurafood.evaluations.dto.PaymentDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentsRabbitListener {

    @RabbitListener(queues = "alura-food.payments-ms.payments-details.evaluations-ms")
    public void getPaymentsMessages(@Payload PaymentDto payment){
        System.out.println(payment.toString());
    }

}
