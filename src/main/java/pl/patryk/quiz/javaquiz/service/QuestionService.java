package pl.patryk.quiz.javaquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(long id) {
        return questionRepository.findById(id);
    }

    public void save(Question question) {
        questionRepository.save(question);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
