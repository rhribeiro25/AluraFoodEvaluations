package br.com.alurafood.evaluations.rabbitmq;

import br.com.alurafood.evaluations.client.OrderClient;
import br.com.alurafood.evaluations.dto.OrderDto;
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

    @Autowired
    private OrderClient orderClient;

    @RabbitListener(queues = "alura-food.payments-ms.payments-confirmed.evaluations-ms")
    public void getPaymentsMessages(@Payload PaymentDto payment){
        OrderDto orderDto = orderClient.getOrderById(payment.getOrderId());
        orderDto.getOrderItems().stream().map(orderItem ->
                Evaluation.builder()
                        .status(EvaluationStatus.PENDING)
                        .productId(orderItem.getProduct().getId())
                        .points(BigDecimal.valueOf(0.00))
                        .comment("")
                        .build()
        )
                .findFirst()
                .ifPresent(evaluationRepository::save);
    }
}
