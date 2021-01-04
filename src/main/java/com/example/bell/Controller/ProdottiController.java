package com.example.bell.Controller;


import com.example.bell.Entity.Prodotti;
import com.example.bell.Services.ProdottiService;
import com.example.bell.support.exceptions.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotti")
@CrossOrigin("http://localhost:8080")
public class ProdottiController
{

    @Autowired
    ProdottiService prodottiService;

    @CrossOrigin("http://localhost:8080")
    @PostMapping("/addProdotto")
    public ResponseEntity aggiungiProdotto(@RequestBody /*@Valid */Prodotti p){
        prodottiService.aggiungiProdotto(p);
        return new ResponseEntity<>(new ResponseMessage("Aggiunto con successo"), HttpStatus.OK);
    }

    @GetMapping("/listaprodotti")
    public List<Prodotti> getProdotti(){
        return prodottiService.listaProdotti();
    }

    @CrossOrigin("http://localhost:8080")
    @PostMapping("/modificaProdotto")
    public void modificaProdotto(String titolo, String immagine, String descrizione,double prezzo,Integer quantita, String marca){
        prodottiService.modificaProdotto(titolo, immagine, descrizione,  prezzo, quantita,  marca );

    }

    @GetMapping("/prodottoPerId/{id}") // Recupero il singolo elemento passando l'id cosi': {id}
    @CrossOrigin("http://localhost:8080")
    public ResponseEntity findById(@PathVariable  int id) throws Exception {
        Prodotti tmp =prodottiService.findById(id);
        if(tmp == null) {
            return new ResponseEntity<>(new ResponseMessage("L'utente non esiste!"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @DeleteMapping("/eliminaProdotto/{id}")
    @CrossOrigin("http://localhost:8080")
    public void deleteById(@PathVariable int id){
        prodottiService.deleteById(id);
    }

}
