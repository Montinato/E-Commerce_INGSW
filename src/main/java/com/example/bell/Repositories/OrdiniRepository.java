package com.example.bell.Repositories;

import com.example.bell.Entity.Ordini;
import com.example.bell.Entity.Prodotti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdiniRepository extends JpaRepository<Ordini, Integer> {
    List<Prodotti> findOrdinisById(int id);
    List<Ordini> findAll();


}
