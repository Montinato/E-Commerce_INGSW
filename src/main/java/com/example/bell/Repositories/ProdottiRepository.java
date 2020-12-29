package com.example.bell.Repositories;

import com.example.bell.Entity.Prodotti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottiRepository extends JpaRepository<Prodotti,Integer> {
    @Modifying
    @Query("update Prodotti p set p.nome = ?1, p.immagine = ?2,p.descrizione=?3, p.prezzo=?4, p.quantità=?5, p.marca=?6  where p.id = ?1")
    void modificaProdotto(String nome, String immagine, String descrizione,double prezzo,Integer quantita,String marca);

    Prodotti findById(int id);
}
