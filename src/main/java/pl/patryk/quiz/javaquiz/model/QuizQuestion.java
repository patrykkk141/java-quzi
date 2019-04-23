package pl.patryk.quiz.javaquiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_question_id")
    private long quizQuestionId;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "quizQuestion")
    private List<QuizQuestionAnswer> quizQuestionAnswers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public long getQuizQuestionId() {
        return quizQuestionId;
    }

    public void setQuizQuestionId(long quizQuestionId) {
        this.quizQuestionId = quizQuestionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<QuizQuestionAnswer> getQuizQuestionAnswers() {
        return quizQuestionAnswers;
    }

    public void setQuizQuestionAnswers(List<QuizQuestionAnswer> quizQuestionAnswers) {
        this.quizQuestionAnswers = quizQuestionAnswers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
