package fr.nsurget.nicolasexamspringboot.Citydex.validator.annotation;

import fr.nsurget.nicolasexamspringboot.Citydex.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueEmail {

    String message() default "This email already exists !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
