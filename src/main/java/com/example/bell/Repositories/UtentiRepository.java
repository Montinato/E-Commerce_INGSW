package com.example.bell.Repositories;

import com.example.bell.Entity.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti,Integer> {
    Utenti findByEmail(String email);
}
