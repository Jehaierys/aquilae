package com.example.aquilae.sneakers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SneakersDTO {
    private Long id;
    private String model;
    private int size;
    private Integer quantity;
}
