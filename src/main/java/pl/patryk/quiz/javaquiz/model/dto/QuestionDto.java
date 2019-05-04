package pl.patryk.quiz.javaquiz.model.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class QuestionDto {
    private long questionId;
    @NotEmpty
    private String text;
    private String listing;
    private String imageUrl;
    @NotEmpty
    private List<AnswerDto> answers;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
