package pl.patryk.quiz.javaquiz.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/general")
    public String x() {
        return "general";
    }
}
