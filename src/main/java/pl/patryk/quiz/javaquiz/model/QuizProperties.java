package pl.patryk.quiz.javaquiz.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.patryk.quiz.javaquiz.enums.QuizType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.Serializable;

public class QuizProperties implements Serializable {
    @NotNull
    private QuizType quizType;
    @NotNull
    @Min(300000)
    @Max(7200000)
    private long quizTimeInMillis;
    @NotNull
    @Min(5)
    @Max(100)
    private int quizLength;
    @Min(2)
    @Max(6)
    @NotNull
    private int answersQuantity;

    private static QuizProperties instance;

    public QuizProperties() {
    }

    public static QuizProperties getInstance() {
        if (instance == null) {
            try {
                ObjectMapper o = new ObjectMapper();
                Resource resource = new ClassPathResource("quiz-properties.json");
                instance = o.readValue(resource.getFile(), QuizProperties.class);
            } catch (IOException e) {
                System.out.println("Could not initialize PROPERTIES FROM JSON");
            }
        }
        return instance;
    }

    public static void updateInstance(QuizProperties p) {
        if (p != null) {
            instance.setAnswersQuantity(p.getAnswersQuantity());
            instance.setQuizLength(p.getQuizLength());
            instance.setQuizTimeInMillis(p.getQuizTimeInMillis());
            instance.setQuizType(p.getQuizType());
        }
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public long getQuizTimeInMillis() {
        return quizTimeInMillis;
    }

    public void setQuizTimeInMillis(long quizTimeInMillis) {
        this.quizTimeInMillis = quizTimeInMillis;
    }

    public int getQuizLength() {
        return quizLength;
    }

    public void setQuizLength(int quizLength) {
        this.quizLength = quizLength;
    }

    public int getAnswersQuantity() {
        return answersQuantity;
    }

    public void setAnswersQuantity(int answersQuantity) {
        this.answersQuantity = answersQuantity;
    }
}
