package br.com.alurafood.evaluations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDateTime orderDate;
    private String orderStatus;
    private List<OrderItemDto> orderItems;



}
