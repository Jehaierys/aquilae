package com.example.aquilae.user;

import com.example.aquilae.sneakers.Sneakers;
import com.example.aquilae.sneakers.SneakersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserRepo userRepo;
    private final SneakersRepo sneakersRepo;

    @GetMapping("/users")
    public List<User> users() {
        return userRepo.findAll();
    }
    @GetMapping("/sneakers")
    public List<Sneakers> sneakers() {
        return sneakersRepo.findAll();
    }
    @DeleteMapping("/sneakers")
    public ResponseEntity<?> deleteSneakers(@RequestBody Long id) {
        sneakersRepo.deleteById(id);
        if (sneakersRepo.getReferenceById(id) == null) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
