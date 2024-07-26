package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserDTO;
import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO) {
        userService.registerUser(userDTO);

        return "redirect:index";
    }

    @RequestMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        boolean isLoginSuccess = userService.loginUser(userLoginDTO);

        return isLoginSuccess ? "index" : "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();

        return "auth-login";
    }
}
