package pl.patryk.quiz.javaquiz.controller;

import pl.patryk.quiz.javaquiz.enums.RoleType;
import pl.patryk.quiz.javaquiz.model.User;
import pl.patryk.quiz.javaquiz.model.dto.UserCreateDto;
import pl.patryk.quiz.javaquiz.model.dto.UserDto;

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

}
