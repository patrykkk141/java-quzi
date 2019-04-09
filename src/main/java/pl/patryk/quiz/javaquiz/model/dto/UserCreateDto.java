package pl.patryk.quiz.javaquiz.model.dto;

import validator.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserCreateDto {

    @NotEmpty
    @Size(min = 3, max = 255)
    private String userName;
    @NotEmpty
    @Size(min = 3, max = 255)
    private String password;
    @NotEmpty
    @Size(min = 3, max = 255)
    private String matchingPassword;
    @Email
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
