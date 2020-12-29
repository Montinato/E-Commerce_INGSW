package com.example.bell.Services;


import com.example.bell.Entity.Utenti;
import com.example.bell.Repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtentiService {

    @Autowired
    UtentiRepository utentiRepository;

    @Transactional(readOnly = false)
    public Utenti salvaUtente(Utenti u){
        return utentiRepository.save(u);
    }

    @Transactional(readOnly = true)
    public Utenti findByEmail(String email){
        return utentiRepository.findByEmail(email);
    }


}
