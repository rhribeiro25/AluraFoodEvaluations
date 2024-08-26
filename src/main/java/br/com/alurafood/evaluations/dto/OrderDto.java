package br.com.alurafood.evaluations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private ProductDto product;
    private LocalDateTime orderDate;
    private OrderStatusDto orderStatus;
    private List<OrderItemDto> orderItems = new ArrayList<>();



}