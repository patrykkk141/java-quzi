package validator;

import pl.patryk.quiz.javaquiz.model.dto.PasswordDto;
import pl.patryk.quiz.javaquiz.model.dto.UserCreateDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            UserCreateDto cred = (UserCreateDto) obj;
            return cred.getPassword().equals(cred.getMatchingPassword());
        } catch (ClassCastException e) {
            PasswordDto cred = (PasswordDto) obj;
            return cred.getPassword().equals(cred.getMatchingPassword());
        }
    }
}