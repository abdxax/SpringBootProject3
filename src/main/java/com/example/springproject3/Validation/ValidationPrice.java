package com.example.springproject3.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PriceValidation.class)
public @interface ValidationPrice {
    public String message() default "Price must be postive value  ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
