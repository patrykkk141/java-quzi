package pl.patryk.quiz.javaquiz.model.dto;

import java.util.Date;
import java.util.List;

public class QuizDto {
    private long quizId;
    private Date date;
    private int score;
    private List<QuizQuestionDto> questionList;

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
