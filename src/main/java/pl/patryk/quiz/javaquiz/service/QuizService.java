package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.repository.QuizRepository;

import java.util.Date;

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

    //Generating test
    public Quiz generateTest(QuizType type, int length, int answersQuantity) {
        Quiz test = new Quiz();
        test.setDate(new Date(System.currentTimeMillis()));
        test.setQuizQuestions(quizQuestionService.generateRandomQuestions(length, type, test, answersQuantity));

        return test;
    }


}
