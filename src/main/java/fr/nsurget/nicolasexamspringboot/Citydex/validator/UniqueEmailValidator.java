package fr.nsurget.nicolasexamspringboot.Citydex.validator;


import fr.nsurget.nicolasexamspringboot.Citydex.validator.annotation.UniqueEmail;
import fr.nsurget.nicolasexamspringboot.Citydex.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Autowired
    UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByEmail(email).isEmpty();
    }

}
