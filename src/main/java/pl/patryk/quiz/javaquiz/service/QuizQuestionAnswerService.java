package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.controller.Converter;
import pl.patryk.quiz.javaquiz.enums.AnswerType;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;
import pl.patryk.quiz.javaquiz.model.QuizQuestionAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizQuestionAnswerService {

    private final AnswerService answerService;

    @Autowired
    public QuizQuestionAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public List<QuizQuestionAnswer> generateRandomAnswers(QuizQuestion question, QuizType type, int answersQuantity) {
        if (type == QuizType.SINGLE) {
            List<Answer> answers = new ArrayList<>();
            answers.add(answerService.getRandomAnswersByQuestionAndAnswerType(question.getQuestion(), AnswerType.POSITIVE).get(0));
            answers.addAll(answerService.getRandomAnswersByQuestionAndAnswerType(question.getQuestion(), AnswerType.NEGATIVE).subList(0, answersQuantity - 1));
            return answers.stream().map(x -> Converter.toQuizQuestionAnswer(x, question)).collect(Collectors.toList());

        } else
            return answerService.findAllByQuestion(question.getQuestion()).subList(0, answersQuantity).stream().map(x -> Converter.toQuizQuestionAnswer(x, question)).collect(Collectors.toList());
    }

}
