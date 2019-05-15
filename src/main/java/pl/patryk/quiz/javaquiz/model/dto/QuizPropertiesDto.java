package pl.patryk.quiz.javaquiz.model.dto;

import pl.patryk.quiz.javaquiz.enums.QuizType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class QuizPropertiesDto {
    @NotNull
    private QuizType quizType;
    @NotNull
    @Min(5)
    @Max(240)
    private long quizTypeInMinutes;
    @NotNull
    @Min(5)
    @Max(100)
    private int quizLength;
    @NotNull
    @Min(2)
    @Max(6)
    private int answersQuantity;

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public long getQuizTypeInMinutes() {
        return quizTypeInMinutes;
    }

    public void setQuizTypeInMinutes(long quizTypeInMinutes) {
        this.quizTypeInMinutes = quizTypeInMinutes;
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
