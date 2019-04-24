package pl.patryk.quiz.javaquiz.model.dto;

public class QuizQuestionAnswerDto extends AnswerDto {
    private boolean marked;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
