package pl.patryk.quiz.javaquiz.model;

import pl.patryk.quiz.javaquiz.enums.QuizType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class QuizProperties {

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

    public QuizProperties(@NotNull QuizType quizType, @NotNull @Min(300000) @Max(7200000) long quizTimeInMillis, @NotNull @Min(5) @Max(100) int quizLength, @Min(2) @Max(6) @NotNull int answersQuantity) {
        this.quizType = quizType;
        this.quizTimeInMillis = quizTimeInMillis;
        this.quizLength = quizLength;
        this.answersQuantity = answersQuantity;
    }

    public QuizProperties() {

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
