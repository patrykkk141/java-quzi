package pl.patryk.quiz.javaquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JavaQuizApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JavaQuizApplication.class, args);
	}

}
