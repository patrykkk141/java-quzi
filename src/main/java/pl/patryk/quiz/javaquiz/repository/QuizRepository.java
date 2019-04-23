package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.quiz.javaquiz.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
