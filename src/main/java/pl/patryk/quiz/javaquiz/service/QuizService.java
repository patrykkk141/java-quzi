package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Quiz;

import java.util.Date;

@Service
public class QuizService {

    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizService(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    //Generating test
    public Quiz generateTest(QuizType type, int length, int answersQuantity) {
        Quiz test = new Quiz();
        test.setDate(new Date(System.currentTimeMillis()));
        test.setQuizQuestions(quizQuestionService.generateRandomQuestions(length, type, test, answersQuantity));

        return test;
    }


}
