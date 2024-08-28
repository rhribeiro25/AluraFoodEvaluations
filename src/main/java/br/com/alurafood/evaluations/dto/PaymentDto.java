package br.com.alurafood.evaluations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;
    private BigDecimal payValue;
    private String payName;
    private String payNumber;
    private String payExpiration;
    private String payCode;
    private String payStatus;
    private Long orderId;
    private Long paymentMethodId;

}
