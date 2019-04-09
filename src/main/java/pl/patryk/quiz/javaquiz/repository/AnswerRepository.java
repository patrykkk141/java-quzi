package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryk.quiz.javaquiz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
