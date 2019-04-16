package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private long answerId;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Boolean positive;

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "question_id")
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
