package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.patryk.quiz.javaquiz.exception.BadRequestException;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.dto.QuestionDto;
import pl.patryk.quiz.javaquiz.service.ImageService;
import pl.patryk.quiz.javaquiz.service.QuestionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final ImageService imageService;

    @Autowired
    public QuestionController(QuestionService questionService, ImageService imageService) {
        this.questionService = questionService;
        this.imageService = imageService;
    }

    @GetMapping("/api/question/all")
    public ResponseEntity<List> getAllQuestion(@RequestParam(value = "show_answers") boolean showAnswers) {
        List<Question> questions = questionService.findAll();
        return new ResponseEntity<>(questions.stream().map(x -> Converter.toQuestionDto(x, showAnswers)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/api/question/{id}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("id") long id, @RequestParam(value = "show_answers", required = true) Boolean showAnswers) throws NotFoundException {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent())
            return new ResponseEntity<>(Converter.toQuestionDto(question.get(), showAnswers), HttpStatus.OK);

        throw new NotFoundException("Question not found");
    }

    @PostMapping("/api/question")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody @Valid QuestionDto dto) {
        Question question = Converter.fromQuestionDto(dto);
        List<Answer> answers = dto.getAnswers().stream().map(Converter::fromAnswerDto).collect(Collectors.toList());

        for (Answer x : answers) x.setQuestion(question);
        question.setAnswers(answers);

        questionService.save(question);
        return new ResponseEntity<>(Converter.toQuestionDto(question, true), HttpStatus.CREATED);
    }

    @PutMapping("/api/question/{id}")
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

    @DeleteMapping("/api/question/{id}")
    public ResponseEntity<QuestionDto> deleteQuestion(@PathVariable("id") long id) throws NotFoundException {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            questionService.delete(question.get());
            return new ResponseEntity<>(Converter.toQuestionDto(question.get(), true), HttpStatus.OK);
        }

        throw new NotFoundException("Question not found!");
    }

    @PostMapping("/api/question/{id}/image")
    public ResponseEntity<?> uploadImage(@PathVariable("id") long id,
                                         @RequestParam("file") MultipartFile file) throws BadRequestException, NotFoundException {
        Optional<Question> q = questionService.findById(id);
        if (q.isPresent()) {
            Question question = q.get();
            try {
                question.setImageUrl(imageService.saveImage(file));
                return new ResponseEntity<>(Converter.toQuestionDto(question, true), HttpStatus.OK);
            } catch (Exception e) {
                throw new BadRequestException("File could not be saved!");
            }
        }
        throw new NotFoundException("Question with id: " + id + " not exists!");
    }
}
