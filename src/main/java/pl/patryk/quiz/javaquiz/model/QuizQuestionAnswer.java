package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "quiz_question_answer")
public class QuizQuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_question_answer_id")
    private long quizQuestionAnswerId;
    private Boolean marked;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_question_id")
    private QuizQuestion quizQuestion;

    public long getQuizQuestionAnswerId() {
        return quizQuestionAnswerId;
    }

    public void setQuizQuestionAnswerId(long quizQuestionAnswerId) {
        this.quizQuestionAnswerId = quizQuestionAnswerId;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public QuizQuestion getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(QuizQuestion quizQuestion) {
        this.quizQuestion = quizQuestion;
    }
}
