package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    private final UserRepository userRepository;
//    private final UserRoleRepository userRoleRepository;
//
//    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
//        this.userRepository = userRepository;
//        this.userRoleRepository = userRoleRepository;
//    }

//    @Override
//    public boolean registerUser(UserRegisterDTO userRegisterDTO) {
//        userRepository.save(map(userRegisterDTO, userRoleRepository));
//
//        return true;
//    }

//    private static User map(UserRegisterDTO userRegisterDTO, UserRoleRepository userRoleRepository) {
//        UserRole role = new UserRole();
//        role.setRoleType(RoleType.ADMIN);
//
//        User user = new User()
//                .setActive(true)
//                .setUsername(userRegisterDTO.getUsername())
//                .setPassword(userRegisterDTO.getPassword())
//                .setFirstName(userRegisterDTO.getFirstName())
//                .setLastName(userRegisterDTO.getLastName())
//                .setCreated(new Date())
//                .setModified(new Date())
//                .setRole(role);
//
//        userRoleRepository.save(role);
//
//        return user;
//    }
}
