package br.com.alurafood.evaluations.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    @NotNull
    private Long orderId;

    @NotNull
    @Digits(integer=5, fraction=2)
    private BigDecimal points;

    @Size(max = 256)
    private String description;

}
