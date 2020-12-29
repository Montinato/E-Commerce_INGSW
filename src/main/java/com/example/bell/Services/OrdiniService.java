package com.example.bell.Services;


import com.example.bell.Entity.Ordini;
import com.example.bell.Entity.Prodotti;
import com.example.bell.Repositories.OrdiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdiniService {

    @Autowired
    OrdiniRepository or;

    @Transactional(readOnly=false)
    public void addOrdine(Ordini o){
        or.save(o);
    }

    @Transactional(readOnly=true)
    public List<Prodotti> getOrdiniById(int id){
        return or.findOrdinisById(id);
    }

    @Transactional(readOnly=false)
    public List<Ordini> findAll(){
        return or.findAll();
    }
}
