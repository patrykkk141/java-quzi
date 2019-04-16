package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.dto.QuestionDto;
import pl.patryk.quiz.javaquiz.service.QuestionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question/all")
    public ResponseEntity<List> getAllQuestion(@RequestParam(value = "show_answers") boolean showAnswers) {
        List<Question> questions = questionService.findAll();
        return new ResponseEntity<>(questions.stream().map(x -> Converter.toQuestionDto(x, showAnswers)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("id") long id, @RequestParam(value = "show_answers", required = true) Boolean showAnswers) throws NotFoundException {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent())
            return new ResponseEntity<>(Converter.toQuestionDto(question.get(), showAnswers), HttpStatus.OK);

        throw new NotFoundException("Question not found");
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody @Valid QuestionDto dto) {
        Question question = Converter.fromQuestionDto(dto);
        List<Answer> answers = dto.getAnswers().stream().map(Converter::fromAnswerDto).collect(Collectors.toList());

        for (Answer x : answers) x.setQuestion(question);
        question.setAnswers(answers);

        questionService.save(question);
        return new ResponseEntity<>(Converter.toQuestionDto(question, true), HttpStatus.CREATED);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable("id") long id, @RequestBody @Valid QuestionDto dto) throws NotFoundException {
        Optional<Question> optional = questionService.findById(id);
        if (optional.isPresent()) {
            Question question = Converter.fromQuestionDto(dto);
            question.setQuestionId(optional.get().getQuestionId());
            question.setAnswers(optional.get().getAnswers());

            questionService.save(question);

            return new ResponseEntity<>(Converter.toQuestionDto(question, true), HttpStatus.OK);
        }

        throw new NotFoundException("Question not found!");
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable("id") long id) throws NotFoundException {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            questionService.delete(question.get());
            return new ResponseEntity<>(Converter.toQuestionDto(question.get(), true), HttpStatus.OK);
        }

        throw new NotFoundException("Question not found!");
    }

}
