package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.model.dto.UserLoginDTO;

public interface UserService {
    boolean registerUser(UserRegisterDTO UserRegisterDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
