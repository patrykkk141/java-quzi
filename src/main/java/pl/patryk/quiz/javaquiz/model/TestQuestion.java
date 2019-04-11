package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_question")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_question_id")
    private long testQuestionId;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany
    private List<TestQuestionAnswer> testQuestionAnswers;

    public long getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(long testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<TestQuestionAnswer> getTestQuestionAnswers() {
        return testQuestionAnswers;
    }

    public void setTestQuestionAnswers(List<TestQuestionAnswer> testQuestionAnswers) {
        this.testQuestionAnswers = testQuestionAnswers;
    }
}
