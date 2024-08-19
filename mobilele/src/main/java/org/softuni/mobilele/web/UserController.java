package org.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

//    @PostMapping("/register")
//    public String register(@Valid UserRegisterDTO userRegisterDTO,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes) {
//
//        boolean isRegisterSuccess = false;
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes
//                    .addFlashAttribute("userRegisterDTO", userRegisterDTO);
//            redirectAttributes
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
//        } else {
//            isRegisterSuccess = userService.registerUser(userRegisterDTO);
//        }
//
//        return isRegisterSuccess ? "redirect:/users/login" : "redirect:/users/register";
//    }
//
    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }
}