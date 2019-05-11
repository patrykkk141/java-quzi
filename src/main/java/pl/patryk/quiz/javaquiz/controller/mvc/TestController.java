package pl.patryk.quiz.javaquiz.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.patryk.quiz.javaquiz.service.QuizPropertiesService;

@Controller
public class TestController {

    private final QuizPropertiesService quizPropertiesService;

    @Autowired
    public TestController(QuizPropertiesService quizPropertiesService) {

        this.quizPropertiesService = quizPropertiesService;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/general")
    public String x() {
        return "general";
    }

   /* @GetMapping("/quiz-properties")
    public String getQuizPropertiesForm(Model model) {
        model.addAttribute("quizProperties", new QuizProperties());
        return "quiz-properties";
    }

    @PostMapping("/quiz-properties")
    public String updateQuizProperties(@ModelAttribute @Valid QuizProperties quizProperties, BindingResult result) throws Exception {
        if (result.hasErrors()) return "quiz-properties";

        *//*this.properties = quizProperties;*//*
        quizPropertiesService.updatePropertiesFile(quizProperties);
        return "redirect:/home";
    }*/
}
