package com.oteller.example.gateway.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrongPassword {
    String message() default "En az 8 karakter ve kucuk buyuk harf barindirmalidir.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
