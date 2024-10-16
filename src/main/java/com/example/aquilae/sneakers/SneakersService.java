package com.example.aquilae.sneakers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
    public void deleteSneakers(Long id) {
        sneakersRepo.deleteById(id);
    }
    public void save(Sneakers sneakers) {
        sneakersRepo.save(sneakers);
    }
}
