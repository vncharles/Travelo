package com.fit.Travelo.repository;

import com.fit.Travelo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);


    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);
}
