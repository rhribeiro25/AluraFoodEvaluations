package br.com.alurafood.evaluations.repository;

import br.com.alurafood.evaluations.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

}
