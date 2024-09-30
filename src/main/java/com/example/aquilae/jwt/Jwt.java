package com.example.aquilae.jwt;

import com.example.aquilae.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "jwt")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jwt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jwt_seq_gen")
    public Long id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}