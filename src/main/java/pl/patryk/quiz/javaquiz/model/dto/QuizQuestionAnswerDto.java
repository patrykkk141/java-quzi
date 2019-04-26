package pl.patryk.quiz.javaquiz.model.dto;

public class QuizQuestionAnswerDto extends AnswerDto {
    private Boolean marked;

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }
}
