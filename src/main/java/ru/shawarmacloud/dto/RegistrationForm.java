package ru.shawarmacloud.dto;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.shawarmacloud.model.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String street;
    private String city;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName, street, city);
    }
}
