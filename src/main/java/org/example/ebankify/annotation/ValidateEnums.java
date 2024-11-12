package org.example.ebankify.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.ebankify.validators.ValidEnumValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ValidEnumValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValidateEnums {
    Class<? extends Enum<?>> enumClass();
    String message() default "Invalid enum value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}