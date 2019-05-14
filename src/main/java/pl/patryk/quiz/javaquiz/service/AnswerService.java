package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.enums.AnswerType;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.dto.AnswerDto;
import pl.patryk.quiz.javaquiz.repository.AnswerRepository;

import java.util.Collections;
import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAllByQuestion(Question question) {
        return answerRepository.findAllByQuestion(question);
    }

    public List<Answer> findAllByQuestionAndAnswerType(Question question, AnswerType answerType) {
        return answerRepository.findAllByQuestionAndAnswerType(question, answerType);
    }

    public List<Answer> getRandomAnswersByQuestion(Question question) {
        List<Answer> answers = findAllByQuestion(question);
        Collections.shuffle(answers);
        return answers;
    }

    public List<Answer> getRandomAnswersByQuestionAndAnswerType(Question question, AnswerType type) {
        List<Answer> answers = findAllByQuestionAndAnswerType(question, type);
        Collections.shuffle(answers);
        return answers;
    }

    public List<Answer> setNegativeAnswers(List<Answer> l) {
        for (Answer a : l) {
            if (a.getAnswerType() == null)
                a.setAnswerType(AnswerType.NEGATIVE);
        }
        return l;
    }

    public List<Answer> setQuestion(List<Answer> l, Question q) {
        for (Answer a : l) {
            a.setQuestion(q);
        }
        return l;
    }

    public List<Answer> addEmptyAnswers(List<Answer> answers) {
        if (answers.size() < 6) {
            for (int i = answers.size(); i < 6; i++) {
                answers.add(new Answer());
            }
        }
        return answers;
    }
}
