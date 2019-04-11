package pl.patryk.quiz.javaquiz.controller;

import pl.patryk.quiz.javaquiz.enums.RoleType;
import pl.patryk.quiz.javaquiz.model.Answer;
import pl.patryk.quiz.javaquiz.model.Question;
import pl.patryk.quiz.javaquiz.model.User;
import pl.patryk.quiz.javaquiz.model.dto.AnswerDto;
import pl.patryk.quiz.javaquiz.model.dto.QuestionDto;
import pl.patryk.quiz.javaquiz.model.dto.UserCreateDto;
import pl.patryk.quiz.javaquiz.model.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

class Converter {

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
        dto.setPositive(answer.getPositive());

        return dto;
    }

    static Answer fromAnswerDto(AnswerDto dto) {
        Answer answer = new Answer();

        answer.setText(dto.getText());
        answer.setPositive(dto.getPositive());

        return answer;
    }

    static Question fromQuestionDto(QuestionDto dto) {
        Question question = new Question();

        question.setText(dto.getText());
        question.setImageUrl(dto.getImageUrl());

        return question;
    }

}
