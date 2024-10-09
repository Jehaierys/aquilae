package com.example.aquilae.user;

import com.example.aquilae.sneakers.SneakersRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepo userRepo;
    private final SneakersRepo sneakersRepo;

    public List<User> users() {
        logger.info("users() method called");
        logger.info(userRepo.findAll().getFirst().getEmail() + " - is empty: " + userRepo.findAll().isEmpty());
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
