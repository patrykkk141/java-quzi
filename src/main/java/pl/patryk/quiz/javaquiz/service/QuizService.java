package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.enums.AnswerType;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;
import pl.patryk.quiz.javaquiz.model.QuizQuestionAnswer;
import pl.patryk.quiz.javaquiz.model.User;
import pl.patryk.quiz.javaquiz.repository.QuizRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuizQuestionService quizQuestionService) {
        this.quizRepository = quizRepository;
        this.quizQuestionService = quizQuestionService;
    }

    public Optional<Quiz> findById(long id) {
        return quizRepository.findById(id);
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public List<Quiz> findAllByUser(User user) {
        return quizRepository.findAllByUser(user);
    }

    public Optional<Quiz> findByUserAndQuizId(User user, long id) {
        return quizRepository.findByUserAndQuizId(user, id);
    }

    public Quiz generateQuiz(QuizType type, int length, int answersQuantity) {
        Quiz test = new Quiz();
        test.setGenerationDate(new Timestamp(System.currentTimeMillis()));
        test.setQuizQuestions(quizQuestionService.generateRandomQuestions(length, type, test, answersQuantity));

        return test;
    }

    public void setScore(Quiz quiz) {
        int score = 0;
        List<QuizQuestion> q = quiz.getQuizQuestions();
        for (QuizQuestion x : q) {
            List<QuizQuestionAnswer> ans = x.getQuizQuestionAnswers();
            boolean allCorrect = true;
            for (QuizQuestionAnswer y : ans) {
                if (y.getMarked() == null) {
                    allCorrect = false;
                    break;
                } else if (y.getMarked() && y.getAnswer().getAnswerType() == AnswerType.NEGATIVE ||
                        !y.getMarked() && y.getAnswer().getAnswerType() == AnswerType.POSITIVE) {
                    allCorrect = false;
                    break;
                }
            }
            if (allCorrect) score++;
        }
        quiz.setScore(score);
    }

}
