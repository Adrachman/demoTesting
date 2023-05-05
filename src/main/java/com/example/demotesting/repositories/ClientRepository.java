package com.example.demotesting.repositories;

import com.example.demotesting.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByClientname(String clientname);

    Boolean existsByClientname(String clientname);

    Boolean existsByEmail(String email);
}