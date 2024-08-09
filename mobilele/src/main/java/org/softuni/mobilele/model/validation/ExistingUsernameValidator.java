package org.softuni.mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.repository.UserRepository;

import java.util.Optional;

public class ExistingUsernameValidator implements ConstraintValidator<ExistingUsername, String> {
    //TODO: Same code, same logic, different annotation purpose
    private final UserRepository userRepository;

    public ExistingUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> isExistingUser = this.userRepository.findByUsername(username);

        return isExistingUser.isPresent();
    }
}
