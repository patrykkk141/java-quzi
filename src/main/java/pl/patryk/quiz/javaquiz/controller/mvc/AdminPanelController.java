package pl.patryk.quiz.javaquiz.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.controller.Converter;
import pl.patryk.quiz.javaquiz.exception.FileException;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.dto.AnswerDto;
import pl.patryk.quiz.javaquiz.model.dto.ImageDto;
import pl.patryk.quiz.javaquiz.model.dto.QuestionDto;
import pl.patryk.quiz.javaquiz.service.AnswerService;
import pl.patryk.quiz.javaquiz.service.ImageService;
import pl.patryk.quiz.javaquiz.service.QuestionService;

import java.io.File;
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

    @Autowired
    public AdminPanelController(AnswerService answerService, QuestionService questionService, ImageService imageService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.imageService = imageService;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/new")
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

    @PostMapping("/new")
    public String processQuestionForm(@ModelAttribute("question") QuestionDto dto, @ModelAttribute("file") ImageDto image, BindingResult result) {
        Question q = Converter.fromQuestionDto(dto);
        List<Answer> a = dto.getAnswers().stream().filter(x -> x.getText().length() > 0).map(Converter::fromAnswerDto).collect(Collectors.toList());
        q.setAnswers(answerService.setNegativeAnswers(a));
        q.setAnswers(answerService.setQuestion(a, q));

        if (image.getFile() != null) {
            try {
                q.setImageUrl(imageService.saveImage(image.getFile()));
            } catch (IOException | FileException e) {
                System.out.println("Could not save image");
                e.printStackTrace();
            }
        }

        questionService.save(q);
        return "index";
    }

    @GetMapping("/questions")
    public String getQuestions(Model model) {
        List<QuestionDto> q = questionService.findAll().stream().map(x -> Converter.toQuestionDto(x, true)).collect(Collectors.toList());
        model.addAttribute("questions", q);

        return "question";
    }

    @GetMapping("/question/edit/{id}")
    public String getEditForm(@PathVariable("id") long id, Model model) {
        Optional<Question> q = questionService.findById(id);
        if (q.isPresent()) {
            model.addAttribute("question", Converter.toQuestionDto(q.get(), true));
            model.addAttribute("file", new ImageDto());
        } else {
            return "redirect:/questions";
        }
        return "edit";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error!=null) {
            model.addAttribute("errorMessage", "Nieprawny login lub haslo");
        }
        return "login";
    }

}
