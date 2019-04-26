package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.controller.Converter;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizQuestionService {

    private final QuestionService questionService;
    private final QuizQuestionAnswerService quizQuestionAnswerService;

    @Autowired
    public QuizQuestionService(QuestionService questionService, QuizQuestionAnswerService quizQuestionAnswerService) {
        this.questionService = questionService;
        this.quizQuestionAnswerService = quizQuestionAnswerService;
    }

    // generate random questions by QuizType , quiz length and quantity of answers
    List<QuizQuestion> generateRandomQuestions(int length, QuizType type, Quiz quiz, int answersQuantity)  {
        List<Question> questions;
        if (type == QuizType.SINGLE) // if SINGLE find questions with at least 1 positive answer else find questions with right number of answers
            questions = questionService.getQuestionsByQuantityOfPositiveAndNegativeAnswers(1L, (long) (answersQuantity - 1));
        else questions = questionService.getRandomQuestionsByAnswersQuantity((long) answersQuantity);

        if (length <= questions.size()) { //if db has enough question map to QuizQuestion and set random answers to each question
            List<QuizQuestion> quizQuestions = questions.stream().limit(length).map((x) -> Converter.toQuizQuestion(x, quiz)).collect(Collectors.toList());

            for (QuizQuestion x : quizQuestions) {
                x.setQuizQuestionAnswers(quizQuestionAnswerService.generateRandomAnswers(x, type, answersQuantity));
            }
            return quizQuestions;
        }
        throw new InvalidParameterException("There are not enough questions in database! ");
    }



}
