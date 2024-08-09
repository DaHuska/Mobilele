package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.model.entity.UserRole;
import org.softuni.mobilele.model.enums.RoleType;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.repository.UserRoleRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public boolean registerUser(UserRegisterDTO UserRegisterDTO) {
        Optional<User> foundRegisteredUser = userRepository.findByUsername(UserRegisterDTO.getUsername());

        //TODO: Swap with field validation
        if (foundRegisteredUser.isPresent()) {
            return false;
        }

        userRepository.save(map(UserRegisterDTO, userRoleRepository));

        return true;
    }

    private static User map(UserRegisterDTO UserRegisterDTO, UserRoleRepository userRoleRepository) {
        UserRole role = new UserRole();
        role.setRoleType(RoleType.ADMIN);

        User user = new User()
                .setActive(true)
                .setUsername(UserRegisterDTO.getUsername())
                .setPassword(UserRegisterDTO.getPassword())
                .setFirstName(UserRegisterDTO.getFirstName())
                .setLastName(UserRegisterDTO.getLastName())
                .setCreated(new Date())
                .setModified(new Date())
                .setRole(role);

        userRoleRepository.save(role);

        return user;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        //TODO: swap with field validation
        Optional<User> foundExistingUser = userRepository.findByUsername(userLoginDTO.getUsername());

        if (foundExistingUser.isEmpty()) {
            return false;
        }

        if (!userLoginDTO.getPassword().equals(foundExistingUser.get().getPassword())) {
            return false;
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
