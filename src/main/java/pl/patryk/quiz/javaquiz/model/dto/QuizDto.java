package pl.patryk.quiz.javaquiz.model.dto;

import java.sql.Timestamp;
import java.util.List;

public class QuizDto {
    private long quizId;
    private Timestamp startDate;
    private int score;
    private long userId;
    private List<QuizQuestionDto> questionList;

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<QuizQuestionDto> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuizQuestionDto> questionList) {
        this.questionList = questionList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
