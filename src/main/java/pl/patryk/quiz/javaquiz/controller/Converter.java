package pl.patryk.quiz.javaquiz.controller;

import pl.patryk.quiz.javaquiz.enums.RoleType;
import pl.patryk.quiz.javaquiz.model.*;
import pl.patryk.quiz.javaquiz.model.dto.*;

import java.util.stream.Collectors;

public class Converter {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();

        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setRegistrationDate(user.getRegistrationDate());
        return dto;
    }

    public static User fromUserCreateDto(UserCreateDto dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setRole(RoleType.USER);
        user.setUserName(dto.getUserName());
        return user;
    }

    public static QuestionDto toQuestionDto(Question question, boolean showAnswers) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(question.getQuestionId());
        dto.setText(question.getText());
        dto.setCreationDate(question.getCreationDate());
        dto.setCode(question.getCode());
        dto.setImageUrl(question.getImageUrl());

        if (showAnswers)
            dto.setAnswers(question.getAnswers().stream().map(Converter::toAnswerDto).collect(Collectors.toList()));

        return dto;
    }

    public static Question fromQuestionDto(QuestionDto dto) {
        Question question = new Question();

        question.setQuestionId(dto.getQuestionId());
        question.setText(dto.getText());
        question.setImageUrl(dto.getImageUrl());
        question.setCode(dto.getCode());

        return question;
    }

    public static QuizQuestionDto toQuizQuestionDto(QuizQuestion question, boolean showAnswersType) {
        QuizQuestionDto dto = new QuizQuestionDto();
        dto.setQuestionId(question.getQuizQuestionId());
        dto.setText(question.getQuestion().getText());
        dto.setCreationDate(question.getQuestion().getCreationDate());
        dto.setImageUrl(question.getQuestion().getImageUrl());
        dto.setCode(question.getQuestion().getCode());
        dto.setAnswerList(question.getQuizQuestionAnswers().stream().map(x -> Converter.toQuizQuestionAnswerDto(x, showAnswersType)).collect(Collectors.toList()));

        return dto;
    }

    static public QuizQuestion toQuizQuestion(Question question, Quiz quiz) {
        QuizQuestion quizQuestion = new QuizQuestion();

        quizQuestion.setQuestion(question);
        quizQuestion.setQuiz(quiz);

        return quizQuestion;
    }

    public static AnswerDto toAnswerDto(Answer answer) {
        AnswerDto dto = new AnswerDto();
        dto.setAnswerId(answer.getAnswerId());
        dto.setText(answer.getText());
        dto.setAnswerType(answer.getAnswerType());

        return dto;
    }

    public static Answer fromAnswerDto(AnswerDto dto) {
        Answer answer = new Answer();

        answer.setAnswerId(dto.getAnswerId());
        answer.setText(dto.getText());
        answer.setAnswerType(dto.getAnswerType());

        return answer;
    }

    public static QuizQuestionAnswerDto toQuizQuestionAnswerDto(QuizQuestionAnswer answer, boolean showAnswerType) {
        QuizQuestionAnswerDto dto = new QuizQuestionAnswerDto();
        dto.setAnswerId(answer.getQuizQuestionAnswerId());
        dto.setMarked(answer.getMarked());
        dto.setText(answer.getAnswer().getText());
        if (showAnswerType) dto.setAnswerType(answer.getAnswer().getAnswerType());

        return dto;
    }

    public static QuizDto toQuizDto(Quiz quiz, boolean showAnswersType) {
        QuizDto dto = new QuizDto();
        dto.setQuizId(quiz.getQuizId());
        dto.setQuizType(quiz.getQuizType());
        dto.setQuizTimeInMillis(quiz.getQuizTimeInMillis());
        dto.setScore(quiz.getScore());
        dto.setMaxScore(quiz.getMaxScore());
        dto.setStartDate(quiz.getStartDate());
        dto.setEndDate(quiz.getEndDate());
        dto.setUserId(quiz.getUser().getUserId());
        dto.setQuestionList(quiz.getQuizQuestions().stream().map(x -> Converter.toQuizQuestionDto(x, showAnswersType)).collect(Collectors.toList()));
        return dto;
    }

    static public QuizQuestionAnswer toQuizQuestionAnswer(Answer answer, QuizQuestion question) {
        QuizQuestionAnswer quizQuestionAnswer = new QuizQuestionAnswer();
        quizQuestionAnswer.setAnswer(answer);
        quizQuestionAnswer.setQuizQuestion(question);

        return quizQuestionAnswer;
    }

    public static QuizPropertiesDto toQuizPropertiesDto(QuizProperties properties) {
        QuizPropertiesDto dto = new QuizPropertiesDto();
        dto.setQuizType(properties.getQuizType());
        dto.setAnswersQuantity(properties.getAnswersQuantity());
        dto.setQuizLength(properties.getQuizLength());
        dto.setQuizTypeInMinutes((long) (properties.getQuizTimeInMillis() * 1.6666667 * Math.pow(10, -5)));
        return dto;
    }

    public static QuizProperties fromQuizPropertiesDto(QuizPropertiesDto dto) {
        QuizProperties properties = new QuizProperties();

        properties.setQuizType(dto.getQuizType());
        properties.setQuizLength(dto.getQuizLength());
        properties.setAnswersQuantity(dto.getAnswersQuantity());
        properties.setQuizTimeInMillis(dto.getQuizTypeInMinutes() * 60000);
        return properties;
    }
}
