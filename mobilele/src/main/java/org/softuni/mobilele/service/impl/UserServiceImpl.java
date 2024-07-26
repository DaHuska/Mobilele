package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserDTO;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.model.entity.UserRole;
import org.softuni.mobilele.model.enums.RoleType;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.repository.UserRoleRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        Optional<User> foundRegisteredUser = userRepository.findByUsername(userDTO.username());

        if (foundRegisteredUser.isPresent()) {
            throw new IllegalArgumentException("User with username %s already exists".formatted(userDTO.username()));
        }

        userRepository.save(map(userDTO, userRoleRepository));
    }

    private static User map(UserDTO userDTO, UserRoleRepository userRoleRepository) {
        UserRole role = new UserRole();
        role.setRoleType(RoleType.ADMIN);

        User user = new User()
                .setActive(true)
                .setPassword(userDTO.password())
                .setFirstName(userDTO.firstName())
                .setLastName(userDTO.lastName())
                .setUsername(userDTO.username())
                .setRole(role);

        userRoleRepository.save(role);

        return user;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> foundExistingUser = userRepository.findByUsername(userLoginDTO.username());

        if (foundExistingUser.isEmpty()) {
            return false;
//            throw new IllegalArgumentException("User with username %s doesn't exist".formatted(userLoginDTO.username()));
        }

        currentUser
                .setUsername(foundExistingUser.get().getUsername())
                .setFirstName(foundExistingUser.get().getFirstName())
                .setLastName(foundExistingUser.get().getLastName())
                .setLogged(true);

        return true;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }
}
