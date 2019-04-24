package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.dto.QuizDto;
import pl.patryk.quiz.javaquiz.service.QuizService;


@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> getTest(@RequestParam(value = "length", required = true) int length,
                                     @RequestParam(value = "type", required = true) QuizType type,
                                     @RequestParam(value = "answers_quantity", required = true) int answersQuantity) {
        Quiz test = quizService.generateTest(type, length, answersQuantity);
        quizService.save(test);

        QuizDto dto = Converter.toQuizDto(test, false);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
