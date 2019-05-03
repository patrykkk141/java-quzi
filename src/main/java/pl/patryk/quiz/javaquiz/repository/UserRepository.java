package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryk.quiz.javaquiz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUserName(String userName);
}
