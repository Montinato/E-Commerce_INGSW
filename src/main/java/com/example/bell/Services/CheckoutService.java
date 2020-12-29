package com.example.bell.Services;

import com.example.bell.Entity.Checkout;
import com.example.bell.Repositories.CheckoutRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;

@Service
public class CheckoutService {

    @Autowired
    CheckoutRepository cr;

    @Transactional(readOnly = false)
    public void aggiungiCheckout(long productId, int userId, double qty, double total_price, String payment, int orderId) throws Exception {
        try {
            Checkout cart = new Checkout();
            cart.setPrezzo(total_price);
            int ordineId = orderId;
            cart.setIdOrdine(ordineId);
            cart.setIdProdotto(productId);
            cart.setQty(qty);
            cart.setPaymentType(payment);
            cart.setIdUtente(userId);
            cr.save(cart);

        } catch (Exception e) {
            throw new Exception("Error while check" + e.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public Checkout trovaOrdiniByOrdine(int ordineId){
        return cr.findCheckoutsByIdOrdine(ordineId);
    }
}
