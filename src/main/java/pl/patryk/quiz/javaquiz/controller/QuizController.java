package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.exception.BadRequestException;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.dto.QuizDto;
import pl.patryk.quiz.javaquiz.service.QuizQuestionAnswerService;
import pl.patryk.quiz.javaquiz.service.QuizService;

import java.util.Optional;


@RestController
public class QuizController {

    private final QuizService quizService;
    private final QuizQuestionAnswerService answerService;

    @Autowired
    public QuizController(QuizService quizService, QuizQuestionAnswerService answerService) {
        this.quizService = quizService;
        this.answerService = answerService;
    }

    @GetMapping("/quiz")
    public ResponseEntity<QuizDto> getTest(@RequestParam(value = "length", required = true) int length,
                                           @RequestParam(value = "type", required = true) QuizType type,
                                           @RequestParam(value = "answers_quantity", required = true) int answersQuantity) throws BadRequestException {
        if (length < 1 || answersQuantity < 2)
            throw new BadRequestException("Invalid request param, length must be grater than 0 and answersQuantity must be grater than 1");

        Quiz test = quizService.generateTest(type, length, answersQuantity);
        quizService.save(test);
        QuizDto dto = Converter.toQuizDto(test, false);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/quiz")
    public ResponseEntity<QuizDto> getResult(@RequestBody QuizDto dto) throws BadRequestException {
        Optional<Quiz> quiz = quizService.findById(dto.getQuizId());
        if (quiz.isPresent()) {

            answerService.updateMarkedAnswers(quiz.get().getQuizQuestions(), dto.getQuestionList());
            quizService.setScore(quiz.get());

            QuizDto d = Converter.toQuizDto(quiz.get(), true);
            return new ResponseEntity<>(d, HttpStatus.OK);
        }
        throw new BadRequestException("Quiz not found in DB");
    }
}
