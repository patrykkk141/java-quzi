package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.controller.Converter;
import pl.patryk.quiz.javaquiz.enums.AnswerType;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;
import pl.patryk.quiz.javaquiz.model.QuizQuestionAnswer;
import pl.patryk.quiz.javaquiz.model.dto.QuizQuestionAnswerDto;
import pl.patryk.quiz.javaquiz.model.dto.QuizQuestionDto;

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
            return answerService.getRandomAnswersByQuestion(question.getQuestion()).subList(0, answersQuantity).stream().map(x -> Converter.toQuizQuestionAnswer(x, question)).collect(Collectors.toList());
    }

    public void updateMarkedAnswers(List<QuizQuestion> q1, List<QuizQuestionDto> q2) {
        for (int i = 0; i < q1.size(); i++) {
            List<QuizQuestionAnswer> a1 = q1.get(i).getQuizQuestionAnswers();
            List<QuizQuestionAnswerDto> a2 = q2.get(i).getAnswerList();

            for (int j = 0; j < a1.size(); j++) {
                if (a2.get(j).getMarked() == null) break;
                else if (a2.get(j).getMarked()) a1.get(j).setMarked(true);
                else if (!a2.get(j).getMarked()) a1.get(j).setMarked(false);
            }
        }
    }
}
