package ru.shawarmacloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.shawarmacloud.model.User;
import ru.shawarmacloud.repository.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;

            throw new UsernameNotFoundException("User '" + username + "' + not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/design", "/orders").hasRole("USER")
                        .requestMatchers("/", "/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                .build();
    }
}