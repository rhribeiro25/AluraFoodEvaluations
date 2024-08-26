package br.com.alurafood.evaluations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private ProductDto productDto;
    private Integer qtt;
    private String description;
}
