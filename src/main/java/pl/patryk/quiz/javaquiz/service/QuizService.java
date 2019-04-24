package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.enums.AnswerType;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;
import pl.patryk.quiz.javaquiz.model.QuizQuestionAnswer;
import pl.patryk.quiz.javaquiz.repository.QuizRepository;

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

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Optional<Quiz> findById(long id) {
        return quizRepository.findById(id);
    }

    //Generating test
    public Quiz generateTest(QuizType type, int length, int answersQuantity) {
        Quiz test = new Quiz();
        test.setDate(new Date(System.currentTimeMillis()));
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
                if (y.isMarked() && y.getAnswer().getAnswerType() == AnswerType.NEGATIVE ||
                        !y.isMarked() && y.getAnswer().getAnswerType() == AnswerType.POSITIVE) {
                    allCorrect = false;
                    break;
                }
            }
            if (allCorrect) score++;
        }
        quiz.setScore(score);
    }

}
