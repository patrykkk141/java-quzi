package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "test_question_answer")
public class TestQuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_question_answer_id")
    private long testQuestionAnswerId;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "test_question_id")
    private TestQuestion testQuestion;

    public long getTestQuestionAnswerId() {
        return testQuestionAnswerId;
    }

    public void setTestQuestionAnswerId(long testQuestionAnswerId) {
        this.testQuestionAnswerId = testQuestionAnswerId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public TestQuestion getTestQuestion() {
        return testQuestion;
    }

    public void setTestQuestion(TestQuestion testQuestion) {
        this.testQuestion = testQuestion;
    }
}
