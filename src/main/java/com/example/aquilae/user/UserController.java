package com.example.aquilae.user;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<User>> users() {
        logger.info("users() method called");
        logger.info(userService.users().stream().count() + " users found");
        return ResponseEntity.ok(userService.users());
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
