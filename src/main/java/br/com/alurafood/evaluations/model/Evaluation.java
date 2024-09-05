package br.com.alurafood.evaluations.model;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    private Long productId;

    private BigDecimal points;

    private String comment;
}
