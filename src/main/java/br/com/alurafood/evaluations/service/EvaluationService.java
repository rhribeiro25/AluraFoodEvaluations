package br.com.alurafood.evaluations.service;

import br.com.alurafood.evaluations.client.OrderClient;
import br.com.alurafood.evaluations.dto.OrderDto;
import br.com.alurafood.evaluations.dto.PaymentDto;
import br.com.alurafood.evaluations.model.Evaluation;
import br.com.alurafood.evaluations.model.EvaluationStatus;
import br.com.alurafood.evaluations.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private OrderClient orderClient;

    public void createPendingEvaluation(PaymentDto payment){
        OrderDto orderDto = orderClient.getOrderById(payment.getOrderId());
        orderDto.getOrderItems().forEach(orderItem -> {
                    Evaluation evaluation = Evaluation.builder()
                            .status(EvaluationStatus.PENDING)
                            .productId(orderItem.getProduct().getId())
                            .points(BigDecimal.valueOf(0.00))
                            .comment("")
                            .build();
                    evaluationRepository.save(evaluation);
                }
        );
    }
}
