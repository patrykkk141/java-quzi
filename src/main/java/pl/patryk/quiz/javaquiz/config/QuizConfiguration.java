package pl.patryk.quiz.javaquiz.config;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.patryk.quiz.javaquiz.model.QuizProperties;

@Configuration
public class QuizConfiguration {

    @Bean
    public QuizProperties initQuizProperties() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("quiz-properties.json");
        return objectMapper.readValue(resource.getFile(), QuizProperties.class);
    }
}
