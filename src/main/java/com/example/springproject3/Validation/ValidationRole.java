package com.example.springproject3.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RoleValidation.class)
public @interface ValidationRole {
    public String message() default "Role must be Admin or Customer  ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
