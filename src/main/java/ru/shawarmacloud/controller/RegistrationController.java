package ru.shawarmacloud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.shawarmacloud.dto.RegistrationForm;
import ru.shawarmacloud.model.User;
import ru.shawarmacloud.repository.UserRepository;

@Slf4j
@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form){
        User user = userRepository.save(form.toUser(passwordEncoder));
        log.info("User " + user + " registered successfully");
        return "redirect:/login";
    }
}