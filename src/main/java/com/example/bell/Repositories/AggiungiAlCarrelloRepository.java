package com.example.bell.Repositories;

import com.example.bell.Entity.AggiungiAlCarrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AggiungiAlCarrelloRepository extends JpaRepository<AggiungiAlCarrello, Integer> {
    List<AggiungiAlCarrello> findAggiungiAlCarrelloByProdottiByIdProdottoId(int prodId);
    List<AggiungiAlCarrello> findAggiungiAlCarrelloByUtentiByIdUtenteId(int userId);
    void removeAggiungiAlCarrelloByUtentiByIdUtenteId(int userId);
    void removeAggiungiAlCarrelloByProdottiByIdProdottoId(int prod_id);
    AggiungiAlCarrello findAggiungiAlCarrelloById(int id);

    @Modifying
    @Query("update AggiungiAlCarrello a set a.quantità = ?1, a.prezzo = ?2, a.dataAggiunta=?3   where a.id = ?1")
    void modificaCarrello(Double quantità, Double prezzo, Date dataAggiunta);

    @Query("select sum(a.prezzo) from AggiungiAlCarrello a where a.utentiByIdUtente.id=:user_id")
    double getTotalAmountByUserId(@Param("user_id") int user_id);

}
