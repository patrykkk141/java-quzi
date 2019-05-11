package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.patryk.quiz.javaquiz.model.QuizProperties;
import pl.patryk.quiz.javaquiz.service.QuizPropertiesService;

import javax.validation.Valid;

@RestController
public class PropertiesController {

    private QuizProperties quizProperties;
    private final QuizPropertiesService propertiesService;

    @Autowired
    public PropertiesController(QuizProperties quizProperties, QuizPropertiesService propertiesService) {
        this.quizProperties = quizProperties;
        this.propertiesService = propertiesService;
    }

    @GetMapping("/admin/properties")
    public ResponseEntity<QuizProperties> getProperties() {
        return new ResponseEntity<>(quizProperties, HttpStatus.OK);
    }

    @PostMapping("/admin/properties")
    public ResponseEntity<QuizProperties> updateProperties(@RequestBody @Valid QuizProperties p) throws Exception {
        quizProperties = p;
        propertiesService.updatePropertiesFile(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
