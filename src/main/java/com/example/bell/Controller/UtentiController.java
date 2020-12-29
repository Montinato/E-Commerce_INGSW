package com.example.bell.Controller;


import com.example.bell.Entity.Utenti;
import com.example.bell.Services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
@CrossOrigin("http://localhost:4200")
public class UtentiController {


    @Autowired
    UtentiService utentiService;

    @PostMapping("/addUtente")
    public Utenti salvaUtente(@RequestBody /*@Valid*/ Utenti u){
        return utentiService.salvaUtente(u);
    }


}
