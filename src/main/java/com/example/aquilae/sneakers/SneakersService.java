package com.example.aquilae.sneakers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SneakersService {

    private static final Logger logger = LoggerFactory.getLogger(SneakersService.class);

    private final SneakersRepo sneakersRepo;

    public Sneakers findById(Long id) {
        return sneakersRepo.getReferenceById(id);
    }
    public List<Sneakers> getAllSneakers() {
        logger.info("getAllSneakers called");
        return sneakersRepo.findAll();
    }
    public boolean deleteSneakers(Long id) {
        return sneakersRepo.getReferenceById(id).getModel() == null;
    }
}
