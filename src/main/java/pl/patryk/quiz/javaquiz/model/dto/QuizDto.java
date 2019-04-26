package pl.patryk.quiz.javaquiz.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

public class QuizDto {
    @NotNull
    private long quizId;
    @NotNull
    private Timestamp generationDate;
    @NotNull
    private long quizTimeInMillis;
    private int score;
    @NotNull
    private int maxScore;
    private long userId;
    @NotEmpty
    private List<QuizQuestionDto> questionList;

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public Timestamp getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Timestamp generationDate) {
        this.generationDate = generationDate;
    }

    public long getQuizTimeInMillis() {
        return quizTimeInMillis;
    }

    public void setQuizTimeInMillis(long quizTimeInMillis) {
        this.quizTimeInMillis = quizTimeInMillis;
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

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
