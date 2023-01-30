package com.example.springproject3.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class PriceValidation implements ConstraintValidator<ValidationPrice,Double> {
    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        if(aDouble<0){
            return false;
        }
        return true;
    }
}
