package com.example.aquilae.sneakers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SneakerController {
    private final SneakersService sneakersService;
    @GetMapping("/get{id}")
    public ResponseEntity<SneakersDTO> getSneakers(@PathVariable Long id) {
        Sneakers sneakers = sneakersService.findById(id);
        SneakersDTO dto = new SneakersDTO(sneakers.getId(), sneakers.getModel(), sneakers.getSize(), sneakers.getQuantity());
        return ResponseEntity.ok(dto);
    }
}
