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
    public boolean registerUser(UserRegisterDTO userRegisterDTO) {
        userRepository.save(map(userRegisterDTO, userRoleRepository));

        return true;
    }

    private static User map(UserRegisterDTO userRegisterDTO, UserRoleRepository userRoleRepository) {
        UserRole role = new UserRole();
        role.setRoleType(RoleType.ADMIN);

        User user = new User()
                .setActive(true)
                .setUsername(userRegisterDTO.getUsername())
                .setPassword(userRegisterDTO.getPassword())
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setCreated(new Date())
                .setModified(new Date())
                .setRole(role);

        userRoleRepository.save(role);

        return user;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> foundExistingUser = userRepository.findByUsername(userLoginDTO.getUsername());

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
