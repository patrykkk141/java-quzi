package pl.patryk.quiz.javaquiz.model.dto;

import validator.PasswordMatches;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordMatches
public class PasswordDto {

    @NotEmpty
    @Size(min = 3, max = 255)
    private String password;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String matchingPassword;

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
}
