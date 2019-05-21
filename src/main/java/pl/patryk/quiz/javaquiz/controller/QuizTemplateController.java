package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.exception.QuizException;
import pl.patryk.quiz.javaquiz.model.Quiz;
import pl.patryk.quiz.javaquiz.model.QuizProperties;
import pl.patryk.quiz.javaquiz.model.QuizQuestion;
import pl.patryk.quiz.javaquiz.model.dto.QuizDto;
import pl.patryk.quiz.javaquiz.model.dto.QuizQuestionDto;
import pl.patryk.quiz.javaquiz.service.Converter;
import pl.patryk.quiz.javaquiz.service.QuizQuestionAnswerService;
import pl.patryk.quiz.javaquiz.service.QuizService;

import java.util.List;
import java.util.Optional;

@Controller
public class QuizTemplateController {

    private QuizProperties properties;
    private QuizService quizService;
    private QuizQuestionAnswerService answerService;

    @Autowired
    public QuizTemplateController(QuizService quizService, QuizQuestionAnswerService answerService) {
        this.quizService = quizService;
        this.answerService = answerService;
        this.properties = QuizProperties.getInstance();
    }

    @GetMapping("/quiz")
    public String getQuizForm(Model model) {
        QuizDto quiz = null;
        try {
            Quiz q = quizService.generateQuiz(properties.getQuizType(), properties.getQuizLength(), properties.getAnswersQuantity(), properties.getQuizTimeInMillis());
            quizService.save(q);
            quiz = Converter.toQuizDto(q, false);
        } catch (QuizException e) {
            System.out.println("Nie mozna wygenerowac quizu !");
            e.printStackTrace();
        }
        model.addAttribute("quiz", quiz);
        return "quiz";
    }

    @PostMapping("/quiz")
    public String processQuizForm(@ModelAttribute("quiz") QuizDto dto, BindingResult result, Model model) throws NotFoundException {
        Optional<Quiz> quiz = quizService.findById(dto.getQuizId());
        if (quiz.isPresent()) {
            answerService.updateMarkedAnswers(quiz.get().getQuizQuestions(), dto.getQuestionList());
            quizService.setScore(quiz.get());
            quizService.save(quiz.get());

            model.addAttribute("result", String.format("Twój wynik to: %d/%d", quiz.get().getScore(), quiz.get().getMaxScore()));
            return "result";
        }
        throw new NotFoundException("Quiz not found");
    }

}
