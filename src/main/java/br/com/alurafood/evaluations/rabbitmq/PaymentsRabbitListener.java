package br.com.alurafood.evaluations.rabbitmq;

import br.com.alurafood.evaluations.dto.PaymentDto;
import br.com.alurafood.evaluations.model.Evaluation;
import br.com.alurafood.evaluations.model.EvaluationStatus;
import br.com.alurafood.evaluations.repository.EvaluationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentsRabbitListener {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @RabbitListener(queues = "alura-food.payments-ms.payments-confirmed.evaluations-ms")
    public void getPaymentsMessages(@Payload PaymentDto payment){
        Evaluation evaluation = Evaluation.builder()
                .status(EvaluationStatus.PENDING)
                .productId(payment.getOrder().getProduct().getId())
                .points(BigDecimal.valueOf(0.00))
                .comment("")
                .build();
        evaluationRepository.save(evaluation);
    }
}
