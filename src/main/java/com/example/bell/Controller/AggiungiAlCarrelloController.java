package com.example.bell.Controller;


import com.example.bell.Entity.AggiungiAlCarrello;
import com.example.bell.Services.AggiungiAlCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.rmi.activation.ActivationGroupID;
import java.util.List;

// Serve alla classe principale per poter caricare il componente in Run Time in modo automatico

@RestController
@RequestMapping("/carrello")
@CrossOrigin("http://localhost:8080")
public class AggiungiAlCarrelloController
{

    @Autowired
    AggiungiAlCarrelloService as;

    @RequestMapping("/stampa")
    public String Stampa()
    {
        System.out.println("TO MAMMA ");
        return new String("CIAO");
    }


    @PostMapping("/add")
    public void addCarrello(@RequestBody  @Valid AggiungiAlCarrello a) {
        //System.out.println("TO MAMMA");
        AggiungiAlCarrello obj = new AggiungiAlCarrello();
        obj.setQuantità(a.getQuantità());
        obj.setPrezzo(a.getPrezzo());
        obj.setId(a.getId());
        obj.setProdottiByIdProdotto(a.getProdottiByIdProdotto());
        obj.setUtentiByIdUtente(a.getUtentiByIdUtente());
        as.aggiungiCarrello(obj);
    }

    @PostMapping("/modificaQuantità")
    public void modificaQuantita(@RequestBody Integer id, Double qty){
        AggiungiAlCarrello obj = as.cercaCarrelloById(id);
        obj.setQuantità(qty);
        as.modificaQuantitaCarrello(obj);
    }

    @GetMapping("/getByProdotto")
    public List<AggiungiAlCarrello> cercaProdottoCarrello(@RequestBody int prodId){
        return as.cercaCarrelloByIdProdotto(prodId);
    }

    @GetMapping("/getByUtente")
    public List<AggiungiAlCarrello> cercaCarrelloUtente(@RequestBody int userId){
        return as.cercaCarrelloByIdUtente(userId);
    }

    @DeleteMapping("/removeByUtente")
    public void rimuoviCarrelloUtente(@RequestBody int userId){
        as.removeCarrelloByIdUtente(userId);
    }

    @DeleteMapping("/rimuoviByProdotto")
    public void rimuoviProdottoCarrello(@RequestBody int prodId){
        as.removeCarrelloByIdProdotto(prodId);
    }

    @GetMapping("/getByIdCarrello")
    public AggiungiAlCarrello cercaCarrello(@RequestBody int id){
         return as.cercaCarrelloById(id);
    }

}
