package org.softuni.mobilele.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistingUsernameValidator.class)
public @interface ExistingUsername {
    String message() default "User with this username doesn't exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
