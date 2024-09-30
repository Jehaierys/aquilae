package com.example.aquilae.sneakers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakersRepo extends JpaRepository<Sneakers, Long> {
}
