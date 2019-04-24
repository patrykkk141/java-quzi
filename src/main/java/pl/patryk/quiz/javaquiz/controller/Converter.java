package pl.patryk.quiz.javaquiz.controller;

import pl.patryk.quiz.javaquiz.enums.RoleType;
import pl.patryk.quiz.javaquiz.model.*;
import pl.patryk.quiz.javaquiz.model.dto.*;

import java.util.stream.Collectors;

public class Converter {

    static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setRegistrationDate(user.getRegistrationDate());
        return dto;
    }

    static User fromUserCreateDto(UserCreateDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setRole(RoleType.USER);
        user.setUserName(dto.getUserName());
        return user;
    }

    static QuestionDto toQuestionDto(Question question, boolean showAnswers) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(question.getQuestionId());
        dto.setText(question.getText());
        dto.setImageUrl(question.getImageUrl());

        if (showAnswers)
            dto.setAnswers(question.getAnswers().stream().map(Converter::toAnswerDto).collect(Collectors.toList()));

        return dto;
    }


    static AnswerDto toAnswerDto(Answer answer) {
        AnswerDto dto = new AnswerDto();
        dto.setAnswerId(answer.getAnswerId());
        dto.setText(answer.getText());
        dto.setAnswerType(answer.getAnswerType());

        return dto;
    }

    static Answer fromAnswerDto(AnswerDto dto) {
        Answer answer = new Answer();
        answer.setText(dto.getText());
        answer.setAnswerType(dto.getAnswerType());

        return answer;
    }

    static Question fromQuestionDto(QuestionDto dto) {
        Question question = new Question();
        question.setText(dto.getText());
        question.setImageUrl(dto.getImageUrl());

        return question;
    }

    static QuizQuestionAnswerDto toQuizQuestionAnswerDto(QuizQuestionAnswer answer, boolean showAnswerType) {
        QuizQuestionAnswerDto dto = new QuizQuestionAnswerDto();
        dto.setAnswerId(dto.getAnswerId());
        dto.setText(answer.getAnswer().getText());
        if (showAnswerType) dto.setAnswerType(answer.getAnswer().getAnswerType());

        return dto;
    }

    static QuizQuestionDto toQuizQuestionDto(QuizQuestion question, boolean showAnswersType) {
        QuizQuestionDto dto = new QuizQuestionDto();
        dto.setQuestionId(question.getQuizQuestionId());
        dto.setText(question.getQuestion().getText());
        dto.setImageUrl(question.getQuestion().getImageUrl());
        dto.setAnswerList(question.getQuizQuestionAnswers().stream().map((x) -> Converter.toQuizQuestionAnswerDto(x, showAnswersType)).collect(Collectors.toList()));

        return dto;
    }

    static QuizDto toQuizDto(Quiz quiz, boolean showAnswersType) {
        QuizDto dto = new QuizDto();
        dto.setQuizId(quiz.getQuizId());
        dto.setDate(quiz.getDate());
        dto.setQuestionList(quiz.getQuizQuestions().stream().map(x -> Converter.toQuizQuestionDto(x, showAnswersType)).collect(Collectors.toList()));

        return dto;
    }

    static public QuizQuestion toQuizQuestion(Question question, Quiz quiz) {
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuestion(question);
        quizQuestion.setQuiz(quiz);

        return quizQuestion;
    }

    static public QuizQuestionAnswer toQuizQuestionAnswer(Answer answer, QuizQuestion question) {
        QuizQuestionAnswer quizQuestionAnswer = new QuizQuestionAnswer();
        quizQuestionAnswer.setAnswer(answer);
        quizQuestionAnswer.setQuizQuestion(question);

        return quizQuestionAnswer;
    }
}
