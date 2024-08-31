package br.com.alurafood.evaluations.rabbitmq;

import br.com.alurafood.evaluations.dto.PaymentDto;
import br.com.alurafood.evaluations.service.EvaluationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class PaymentsRabbitListener {

    @Autowired
    private EvaluationService evaluationService;

    @RabbitListener(queues = "alura-food.payments-ms.payments-confirmed.evaluations-ms")
    public void getPaymentsMessages(@Payload PaymentDto payment){
        evaluationService.createPendingEvaluation(payment);
    }
}
