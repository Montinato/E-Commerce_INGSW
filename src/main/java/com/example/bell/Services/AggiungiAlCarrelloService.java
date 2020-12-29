package com.example.bell.Services;

import com.example.bell.Entity.AggiungiAlCarrello;
import com.example.bell.Entity.Checkout;
import com.example.bell.Entity.Prodotti;
import com.example.bell.Entity.Utenti;
import com.example.bell.Repositories.AggiungiAlCarrelloRepository;
import com.example.bell.Repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.Random;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;

@Service
public class AggiungiAlCarrelloService
{

    @Autowired
    AggiungiAlCarrelloRepository ar;
    @Autowired
    CheckoutRepository cr;

    @Transactional(readOnly = false)
    public void aggiungiCarrello(AggiungiAlCarrello a) {
        ar.save(a);
    }
    @Transactional(readOnly = false)
    public void modificaQuantitaCarrello(AggiungiAlCarrello a){
        Double quantità = a.getQuantità();
        Double prezzo = a.getPrezzo();
        Date data = a.getDataAggiunta();
        ar.modificaCarrello(quantità,prezzo,data);
    }

    @Transactional(readOnly = true)
    public List<AggiungiAlCarrello> cercaCarrelloByIdProdotto(int prodId) {
        return ar.findAggiungiAlCarrelloByProdottiByIdProdottoId(prodId);
    }

    @Transactional(readOnly = true)
    public List<AggiungiAlCarrello> cercaCarrelloByIdUtente(int userId) {
        return ar.findAggiungiAlCarrelloByUtentiByIdUtenteId(userId);
    }

    @Transactional(readOnly = false)
    public void removeCarrelloByIdUtente(int userId) {
        ar.removeAggiungiAlCarrelloByUtentiByIdUtenteId(userId);
    }

    @Transactional(readOnly = false)
    public void removeCarrelloByIdProdotto(int prodId){
        ar.removeAggiungiAlCarrelloByProdottiByIdProdottoId(prodId);
    }

    @Transactional(readOnly = true)
    public AggiungiAlCarrello cercaCarrelloById(int id) {
        return ar.findAggiungiAlCarrelloById(id);

    }

    @Transactional(readOnly = true)
    public Boolean checkTotalAmountAgainstCart(double totalAmount, int userId){
        double total_amount = ar.getTotalAmountByUserId(userId);
        if(total_amount == totalAmount){
            return true;
        }
        return false;
    }



}
