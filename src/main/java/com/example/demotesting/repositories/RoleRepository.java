package com.example.demotesting.repositories;

import java.util.Optional;

import com.example.demotesting.models.ERole;
import com.example.demotesting.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}