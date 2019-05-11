package pl.patryk.quiz.javaquiz.config;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.patryk.quiz.javaquiz.enums.QuizType;
import pl.patryk.quiz.javaquiz.model.QuizProperties;

import java.io.IOException;
import java.util.Scanner;

@Configuration
public class QuizConfiguration {

    @Bean
    public QuizProperties initQuizProperties() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("quiz-properties.json");
        Scanner sc = new Scanner(resource.getFile());
        while(sc.hasNextLine()) System.out.println(sc.nextLine());
        sc.close();
        return objectMapper.readValue(resource.getFile(), QuizProperties.class);
    }

    /*@Bean
    public QuizProperties initQuizProperties() {
        return new QuizProperties(QuizType.SINGLE, 300000, 10, 3);
    }*/
}
