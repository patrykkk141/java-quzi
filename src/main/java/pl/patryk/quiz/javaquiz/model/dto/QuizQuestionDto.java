package pl.patryk.quiz.javaquiz.model.dto;


import java.sql.Timestamp;
import java.util.List;

public class QuizQuestionDto {
    private long questionId;
    private String text;
    private Timestamp creationDate;
    private String imageUrl;
    private String code;
    private List<QuizQuestionAnswerDto> answerList;

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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<QuizQuestionAnswerDto> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<QuizQuestionAnswerDto> answerList) {
        this.answerList = answerList;
    }
}
