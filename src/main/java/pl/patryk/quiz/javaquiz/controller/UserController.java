package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.model.User;
import pl.patryk.quiz.javaquiz.model.dto.PasswordDto;
import pl.patryk.quiz.javaquiz.model.dto.UserCreateDto;
import pl.patryk.quiz.javaquiz.model.dto.UserDto;
import pl.patryk.quiz.javaquiz.service.UserService;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/registration")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto dto) {
        User user = Converter.fromUserCreateDto(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        user.setEnabled(true);
        userService.save(user);

        return new ResponseEntity<>(Converter.toUserDto(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users.stream().map(Converter::toUserDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/api/user")
    public ResponseEntity<UserDto> getUserInfo() throws NotFoundException {
        Optional<User> user = userService.getCurrentLoggedUser();

        if (user.isPresent())
            return new ResponseEntity<>(Converter.toUserDto(user.get()), HttpStatus.OK);
        else
            throw new NotFoundException("User not found!");
    }

    // TODO: 24.04.2019 TO POWINNO BYC DLA NIEZALOGOWANEGO USERA 
/*    @PutMapping("/api/user/reset-password")
    public ResponseEntity<UserDto> resetPassword(@Valid @RequestBody PasswordDto dto) throws NotFoundException {
        Optional<User> user = userService.getCurrentLoggedUser();

        if (user.isPresent()) {
            user.get().setPassword(passwordEncoder.encode(dto.getPassword()));
            userService.save(user.get());

            return new ResponseEntity<>(Converter.toUserDto(user.get()), HttpStatus.OK);
        } else
            throw new NotFoundException("User not found!");
    }*/

    @DeleteMapping("/api/secured/user/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") long id) throws NotFoundException {
        Optional<User> user = userService.findUserById(id);
        
        if (user.isPresent() && user.get().equals(userService.getCurrentLoggedUser().get())) {
            userService.delete(user.get());
            return new ResponseEntity<>(Converter.toUserDto(user.get()), HttpStatus.OK);
        } else
            throw new NotFoundException("User not found");
    }

}
