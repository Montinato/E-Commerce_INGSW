package com.example.bell.Controller;

import com.example.bell.Entity.Ordini;
import com.example.bell.Services.OrdiniService;
import com.example.bell.support.exceptions.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordini")
@CrossOrigin("http://localhost:8080")
public class OrdiniController {

    @Autowired
    OrdiniService os;

    @PostMapping("/aggiungiOrdine")
    public ResponseEntity aggiungiOrdine(@RequestBody Ordini o){
        os.addOrdine(o);
        return new ResponseEntity<>(new ResponseMessage("Aggiunto con successo"), HttpStatus.OK);
    }

    @GetMapping("/tutti")
    public List<Ordini> findAll(){
        return os.findAll();
    }
}
