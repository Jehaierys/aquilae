package com.example.aquilae.sneakers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sneakers")
@AllArgsConstructor
@NoArgsConstructor
public class Sneakers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sneakers_seq_gen")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "size")
    private int size;
    @Column(name = "quantity")
    private int quantity;
}
