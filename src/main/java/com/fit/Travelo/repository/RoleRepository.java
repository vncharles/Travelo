package com.fit.Travelo.repository;

import com.fit.Travelo.entity.ERole;
import com.fit.Travelo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole eRole);
}
