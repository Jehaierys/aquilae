package com.example.aquilae.sneakers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SneakersService {
    private final SneakersRepo sneakersRepo;

    public Sneakers findById(Long id) {
        return sneakersRepo.getReferenceById(id);
    }
}
