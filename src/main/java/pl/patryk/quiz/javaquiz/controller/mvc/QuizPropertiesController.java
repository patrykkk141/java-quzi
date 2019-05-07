package pl.patryk.quiz.javaquiz.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.patryk.quiz.javaquiz.model.QuizProperties;
import pl.patryk.quiz.javaquiz.service.QuizPropertiesService;

import javax.validation.Valid;

@Controller
public class QuizPropertiesController {

    private final QuizPropertiesService quizPropertiesService;

    private QuizProperties quizProperties = QuizProperties.getInstance();

    @Autowired
    public QuizPropertiesController(QuizPropertiesService quizPropertiesService) {
        this.quizPropertiesService = quizPropertiesService;
    }

    @GetMapping("/properties")
    public String getQuizPropertiesForm(Model model) {
        model.addAttribute("quizProperties", new QuizProperties());
        return "quiz-properties";
    }

    @PostMapping("/processPropertiesForm")
    public String updateQuizProperties(@ModelAttribute("quizProperties") @Valid QuizProperties quizProperties, BindingResult result) throws Exception {
        if (result.hasErrors()) return "quiz-properties";
        QuizProperties.updateInstance(quizProperties);
        quizPropertiesService.updatePropertiesFile(quizProperties);
        return "redirect:/home";
    }
}
