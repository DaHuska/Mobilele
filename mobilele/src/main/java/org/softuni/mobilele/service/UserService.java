package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserDTO;
import org.softuni.mobilele.model.dto.UserLoginDTO;

public interface UserService {
    void registerUser(UserDTO userDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
