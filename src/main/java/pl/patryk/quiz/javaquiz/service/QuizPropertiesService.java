package pl.patryk.quiz.javaquiz.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.patryk.quiz.javaquiz.model.QuizProperties;

@Service
public class QuizPropertiesService {

    public void updatePropertiesFile(QuizProperties q) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("quiz-properties.json");
        objectMapper.writeValue(resource.getFile(), q);
    }
}
