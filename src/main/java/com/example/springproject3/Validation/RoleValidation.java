package com.example.springproject3.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class RoleValidation implements ConstraintValidator<ValidationRole,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> rols= Arrays.asList("Admin","Customer");
        return rols.contains(s);
    }
}
