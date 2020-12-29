package com.example.bell.Services;


import com.example.bell.Entity.Prodotti;
import com.example.bell.Repositories.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProdottiService {

    @Autowired
    ProdottiRepository pr;

    @Transactional(readOnly = false)
    public void aggiungiProdotto(Prodotti p){
        pr.save(p);
    }

    @Transactional(readOnly = false)
    public void modificaProdotto(String titolo, String immagine, String descrizione,double prezzo,Integer quantita, String marca){
        pr.modificaProdotto(titolo, immagine, descrizione, prezzo, quantita,  marca);
    }

    @Transactional(readOnly = true)
    public Prodotti findById(int id){
        return pr.findById(id);
    }

    @Transactional(readOnly = false)
    public void deleteById(int id){
        pr.delete(pr.findById(id));
    }

    @Transactional(readOnly = true)
    public List<Prodotti> listaProdotti(){
        return pr.findAll();
    }
}
