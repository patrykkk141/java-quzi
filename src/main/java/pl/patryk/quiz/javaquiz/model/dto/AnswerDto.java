package pl.patryk.quiz.javaquiz.model.dto;

import pl.patryk.quiz.javaquiz.enums.AnswerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AnswerDto {
    private long answerId;
    @NotBlank
    private String text;
    @NotEmpty
    private AnswerType answerType;

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }
}
