package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.exception.FileException;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.QuizProperties;
import pl.patryk.quiz.javaquiz.model.dto.AnswerDto;
import pl.patryk.quiz.javaquiz.model.dto.ImageDto;
import pl.patryk.quiz.javaquiz.model.dto.QuestionDto;
import pl.patryk.quiz.javaquiz.model.dto.QuizPropertiesDto;
import pl.patryk.quiz.javaquiz.service.AnswerService;
import pl.patryk.quiz.javaquiz.service.ImageService;
import pl.patryk.quiz.javaquiz.service.QuestionService;
import pl.patryk.quiz.javaquiz.service.QuizPropertiesService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AdminPanelController {

    private final AnswerService answerService;
    private final QuestionService questionService;
    private final ImageService imageService;
    private final QuizPropertiesService propertiesService;
    private QuizProperties quizProperties;

    @Autowired
    public AdminPanelController(AnswerService answerService, QuestionService questionService, ImageService imageService, QuizPropertiesService propertiesService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.imageService = imageService;
        this.propertiesService = propertiesService;
        quizProperties = QuizProperties.getInstance();
    }

    @GetMapping("/admin/index")
    public String getIndex(Model model) {
        List<Question> question = questionService.findAll().subList(0, 3);
        model.addAttribute("latestQuestions", question);
        return "index";
    }

    @GetMapping("/admin/question/new")
    public String getQuestionForm(Model model) {
        QuestionDto q = new QuestionDto();
        List<AnswerDto> a = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            a.add(new AnswerDto());
        }
        q.setAnswers(a);
        model.addAttribute("question", q);
        model.addAttribute("file", new ImageDto());
        return "new";
    }

    @PostMapping("/admin/question/new")
    public String processQuestionForm(@ModelAttribute("question") QuestionDto dto, @ModelAttribute("file") ImageDto image, BindingResult result) {
        Question q = Converter.fromQuestionDto(dto);
        List<Answer> a = dto.getAnswers().stream().filter(x -> x.getText().length() > 0).map(Converter::fromAnswerDto).collect(Collectors.toList());
        q.setAnswers(answerService.setNegativeAnswers(a));
        q.setAnswers(answerService.setQuestion(a, q));

        if (image.getFile().getOriginalFilename() != null && image.getFile().getOriginalFilename().length() > 0) {
            try {
                q.setImageUrl(imageService.saveImage(image.getFile()));
            } catch (IOException | FileException e) {
                System.out.println("Could not save image");
                e.printStackTrace();
            }
        }

        questionService.save(q);
        return "redirect:/admin/questions";
    }

    @GetMapping("/admin/questions")
    public String getQuestions(Model model) {
        List<QuestionDto> q = questionService.findAll().stream().map(x -> Converter.toQuestionDto(x, true)).collect(Collectors.toList());
        model.addAttribute("questions", q);

        return "question";
    }

    @GetMapping("/admin/question/edit/{id}")
    public String getEditForm(@PathVariable("id") long id, Model model) throws NotFoundException {
        Optional<Question> q = questionService.findById(id);
        if (q.isPresent()) {
            q.get().setAnswers(answerService.addEmptyAnswers(q.get().getAnswers()));
            model.addAttribute("question", Converter.toQuestionDto(q.get(), true));
            model.addAttribute("file", new ImageDto());
            return "edit";
        }
        throw new NotFoundException(String.format("Question with id: %d not exists!", id));
    }

    @PostMapping("/admin/question/edit/{id}")
    public String updateQuestion(@PathVariable("id") long id,
                                 @ModelAttribute @Valid QuestionDto dto,
                                 @ModelAttribute ImageDto file,
                                 BindingResult result) throws NotFoundException {
        Optional<Question> q = questionService.findById(id);
        if (q.isPresent()) {
            processQuestionForm(dto, file, result);
            return "redirect:/admin/questions";
        }
        throw new NotFoundException(String.format("Question with id: %d not exists!", id));
    }

    @GetMapping("/admin/question/delete/{id}")
    public String deleteQuestion(@PathVariable("id") long id) throws NotFoundException {
        Optional<Question> q = questionService.findById(id);
        if (q.isPresent()) {
            questionService.deleteById(id);
            return "redirect:/admin/questions";
        }

        throw new NotFoundException(String.format("Question with id: %d not exists!", id));

    }

    @GetMapping("/admin/properties")
    public String getQuizPropertiesForm(Model model) {
        model.addAttribute("quizProperties", Converter.toQuizPropertiesDto(quizProperties));
        return "quiz-properties";
    }

    @PostMapping("/admin/properties")
    public String updateQuizProperties(@ModelAttribute("quizProperties") @Valid QuizPropertiesDto dto, BindingResult result) throws Exception {
        if (result.hasErrors()) return "quiz-properties";
        QuizProperties.updateInstance(Converter.fromQuizPropertiesDto(dto));
        propertiesService.updatePropertiesFile(quizProperties);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Nieprawny login lub haslo");
        }
        return "login";
    }

}
