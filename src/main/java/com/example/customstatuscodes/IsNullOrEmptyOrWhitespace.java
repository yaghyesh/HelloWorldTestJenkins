package com.example.customstatuscodes;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsNullOrEmptyOrWhitespaceValidator.class)
@Documented
public @interface IsNullOrEmptyOrWhitespace {
    String message() default "Data is mandatory";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}

class IsNullOrEmptyOrWhitespaceValidator implements ConstraintValidator<IsNullOrEmptyOrWhitespace, String>{

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if ( s== null || s.trim().length() == 0)
            return false;
        return true;
    }
}