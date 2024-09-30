package com.example.aquilae.auth;

import com.example.aquilae.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private static final String EMAIL_REGEX = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";

    public static final boolean isValid(String email) {
        if (email == null || email.isEmpty()) { return false; }
        return Pattern.matches(EMAIL_REGEX, email);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authService.authenticate(email, password));
    }

}
