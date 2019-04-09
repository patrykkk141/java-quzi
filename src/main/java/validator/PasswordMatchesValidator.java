package validator;

import pl.patryk.quiz.javaquiz.model.dto.UserCreateDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserCreateDto cred = (UserCreateDto) obj;
        return cred.getPassword().equals(cred.getMatchingPassword());
    }
}