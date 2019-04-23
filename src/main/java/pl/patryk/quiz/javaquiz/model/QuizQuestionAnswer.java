package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;

@Entity
@Table(name = "quiz_question_answer")
public class QuizQuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_question_answer_id")
    private long quizQuestionAnswerId;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "quiz_question_id")
    private QuizQuestion quizQuestion;

    public long getQuizQuestionAnswerId() {
        return quizQuestionAnswerId;
    }

    public void setQuizQuestionAnswerId(long quizQuestionAnswerId) {
        this.quizQuestionAnswerId = quizQuestionAnswerId;
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
