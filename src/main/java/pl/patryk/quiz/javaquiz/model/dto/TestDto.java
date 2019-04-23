package pl.patryk.quiz.javaquiz.model.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class TestDto {
    @NotEmpty
    private long testId;
    @NotEmpty
    private List<QuestionDto> questionDtos;
    private int score;
    private Date date;

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public List<QuestionDto> getQuestionDtos() {
        return questionDtos;
    }

    public void setQuestionDtos(List<QuestionDto> questionDtos) {
        this.questionDtos = questionDtos;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
