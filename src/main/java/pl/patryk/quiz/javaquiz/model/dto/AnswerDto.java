package pl.patryk.quiz.javaquiz.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AnswerDto {
    private long answerId;
    @NotBlank
    private String text;
    @NotNull
    private Boolean positive;

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

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }
}
