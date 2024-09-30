package com.example.aquilae.jwt;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JwtRepo extends JpaRepository<Jwt, Long> {

    @Query(value = """
    SELECT * FROM jwt t
    INNER JOIN users u ON t.user_id = u.id
    WHERE u.id = :id AND (t.expired = false OR t.revoked = false)
    """, nativeQuery = true)
    List<Jwt> findAllValidTokenByUser(long id);


    Optional<Jwt> findByToken(String token);
}
