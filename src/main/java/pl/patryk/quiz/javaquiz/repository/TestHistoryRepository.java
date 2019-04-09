package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryk.quiz.javaquiz.model.TestHistory;

public interface TestHistoryRepository extends JpaRepository<TestHistory, Long> {
}
