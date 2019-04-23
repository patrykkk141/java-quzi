package pl.patryk.quiz.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.patryk.quiz.javaquiz.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT a1.question FROM Answer a1 WHERE a1.question IN (" +
            "SELECT a2.question FROM Answer a2 GROUP BY a2.question, a2.answerType HAVING a2.answerType = 'NEGATIVE' AND count(a2.answerType)>= :num2)" +
            "GROUP BY a1.question, a1.answerType HAVING a1.answerType = 'POSITIVE' AND count(a1.answerType)>= :num1")
    List<Question> findQuestionsByQuantityOfPositiveAndNegativeAnswers(@Param("num1") Long positiveAnswersNumber, @Param("num2") Long negativeAnswersNumber);


    @Query("SELECT a.question FROM Answer a GROUP BY a.question HAVING COUNT(a.question) >= :num1")
    List<Question> findQuestionWithQuantityOfAnswersGraterThan(@Param("num1") Long answersQuantity);
}
