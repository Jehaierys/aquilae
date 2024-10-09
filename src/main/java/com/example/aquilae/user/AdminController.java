package com.example.aquilae.user;

import com.example.aquilae.sneakers.Sneakers;
import com.example.aquilae.sneakers.SneakersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final SneakersService sneakersService;
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> users() {
        logger.info("users() method called");
        logger.info(userService.users().stream().count() + " users found");
        return ResponseEntity.ok(userService.users());
    }
    @GetMapping("/sneakers")
    public ResponseEntity<List<Sneakers>> sneakers() {
        logger.info("sneakers() method called");
        return ResponseEntity.ok(sneakersService.getAllSneakers());
    }
    @DeleteMapping("/sneakers")
    public ResponseEntity<?> deleteSneakers(@RequestBody Long id) {
        if (sneakersService.deleteSneakers(id)) {
            logger.info("sneakers record deleted successfully");
            return ResponseEntity.ok("success");
        } else {
            logger.warn("sneakers record not found, skipped");
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
