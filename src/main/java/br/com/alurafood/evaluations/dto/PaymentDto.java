package br.com.alurafood.evaluations.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PaymentDto {

    private Long id;
    private BigDecimal payValue;
    private String payName;
    private String payNumber;
    private String payExpiration;
    private String payCode;
    private PaymentStatusDto payStatus;
    private OrderDto order;
    private Long paymentMethodId;

}
