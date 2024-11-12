package org.example.ebankify.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.ebankify.annotation.ValidateEnums;

import java.util.Arrays;

public class ValidEnumValidator implements ConstraintValidator<ValidateEnums, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidateEnums constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid, adjust this logic if needed
        }

        // Check if the value is a valid enum constant
        try {
           // Enum.valueOf((Class<Enum>) enumClass, value);
            return true; // If no exception is thrown, the value is valid
        } catch (IllegalArgumentException e) {
            // If the value doesn't match any enum constant, add a constraint violation
            context.disableDefaultConstraintViolation();  // Disable the default violation message
            context.buildConstraintViolationWithTemplate(
                            String.format("The value '%s' is not a valid value for enum %s", value, enumClass.getSimpleName()))
                    .addConstraintViolation(); // Custom message
            return false;
        }
    }
}
