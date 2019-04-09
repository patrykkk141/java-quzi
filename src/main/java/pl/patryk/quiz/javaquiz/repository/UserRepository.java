package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryk.quiz.javaquiz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
