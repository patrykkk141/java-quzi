package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.exception.BadRequestException;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.exception.QuizException;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.QuizProperties;
import pl.patryk.quiz.javaquiz.model.dto.QuizDto;
import pl.patryk.quiz.javaquiz.service.Converter;
import pl.patryk.quiz.javaquiz.service.QuizQuestionAnswerService;
import pl.patryk.quiz.javaquiz.service.QuizService;
import pl.patryk.quiz.javaquiz.service.UserService;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class QuizController {

    private final QuizService quizService;
    private final QuizQuestionAnswerService answerService;
    private final UserService userService;
    private QuizProperties quizProperties;

    @Autowired
    public QuizController(QuizService quizService, QuizQuestionAnswerService answerService, UserService userService) {
        this.quizService = quizService;
        this.answerService = answerService;
        this.quizProperties = QuizProperties.getInstance();
        this.userService = userService;
    }

    @GetMapping("/api/generate-quiz")
    public ResponseEntity<QuizDto> generateQuizWithParams(@RequestParam(value = "length") int length,
                                                          @RequestParam(value = "type") QuizType type,
                                                          @RequestParam(value = "answers_quantity") int answersQuantity,
                                                          @RequestParam(value = "quiz_time_in_millis") long quizTime) throws NotFoundException {
        try {
            Quiz quiz = quizService.generateQuiz(type, length, answersQuantity, quizTime);
            quizService.save(quiz);
            QuizDto dto = Converter.toQuizDto(quiz, false);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (QuizException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @GetMapping("/api/quiz")
    public ResponseEntity<QuizDto> generateQuiz() throws NotFoundException {
        return generateQuizWithParams(quizProperties.getQuizLength(),
                quizProperties.getQuizType(),
                quizProperties.getAnswersQuantity(),
                quizProperties.getQuizTimeInMillis());
    }

    @PostMapping("/api/quiz")
    public ResponseEntity<QuizDto> getResult(@RequestBody @Valid QuizDto dto) throws BadRequestException {
        Optional<Quiz> quiz = quizService.findById(dto.getQuizId());
        if (quiz.isPresent()) {
            if (quiz.get().getEndDate().getTime() > new Timestamp(System.currentTimeMillis()).getTime() + quiz.get().getQuizTimeInMillis()) {
                throw new BadRequestException("Time to complete the quiz passed");
            }
            answerService.updateMarkedAnswers(quiz.get().getQuizQuestions(), dto.getQuestionList());
            quizService.setScore(quiz.get());
            quizService.save(quiz.get());

            QuizDto d = Converter.toQuizDto(quiz.get(), true);
            return new ResponseEntity<>(d, HttpStatus.OK);
        }
        throw new BadRequestException("Quiz not found!");
    }

    @GetMapping("/api/quiz/all")
    public ResponseEntity<List<QuizDto>> getAllQuizzes() {
        List<Quiz> quizList = quizService.findAllByUser(userService.getCurrentLoggedUser());

        return new ResponseEntity<>(quizList.stream().map(x -> Converter.toQuizDto(x, true)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/api/quiz/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable("id") long id) throws NotFoundException {
        Optional<Quiz> quiz = quizService.findByUserAndQuizId(userService.getCurrentLoggedUser(), id);
        if (quiz.isPresent()) return new ResponseEntity<>(Converter.toQuizDto(quiz.get(), true), HttpStatus.OK);

        throw new NotFoundException("Quiz not found!");
    }

}
