package com.example.aquilae.sneakers;

import com.example.aquilae.user.UserController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sneakers")
public class SneakerController {

    private static final Logger logger = LoggerFactory.getLogger(SneakerController.class);

    private final SneakersService sneakersService;

    @GetMapping("/get{id}")
    public ResponseEntity<SneakersDTO> getSneakers(@PathVariable Long id) {
        Sneakers sneakers = sneakersService.findById(id);
        SneakersDTO dto = new SneakersDTO(sneakers.getId(), sneakers.getModel(), sneakers.getSize(), sneakers.getQuantity());
        return ResponseEntity.ok(dto);
    }
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/sneakers")
    public ResponseEntity<List<Sneakers>> getAllSneakers() {
        logger.info("sneakers() method called");
        return ResponseEntity.ok(sneakersService.getAllSneakers());
    }
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/sneakers")
    public ResponseEntity<?> update(@RequestBody Sneakers sneakers) {
        logger.info("sneakers updated");
        sneakersService.save(sneakers);
        return ResponseEntity.ok("Success");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/sneakers")
    public ResponseEntity<?> addSneakers(@RequestBody Sneakers sneakers) {
        sneakersService.save(sneakers);
        return ResponseEntity.ok("Success");
    }
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/sneakers")
    public ResponseEntity<?> deleteSneakers(@RequestBody Long id) {
        sneakersService.deleteSneakers(id);
        return ResponseEntity.internalServerError().build();
    }
}
