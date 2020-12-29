package com.example.bell.Controller;

import com.example.bell.Entity.AggiungiAlCarrello;
import com.example.bell.Entity.Checkout;
import com.example.bell.Services.AggiungiAlCarrelloService;
import com.example.bell.Services.CheckoutService;
import com.sun.org.apache.xpath.internal.objects.XNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    AggiungiAlCarrelloService as;
    @Autowired
    CheckoutService cs;

    //@PostMapping("/add")
    @RequestMapping(path = "/add/{userId}/{total_price}/{payment}", method = RequestMethod.POST)
    public ResponseEntity checkoutOrder(@PathVariable int userId, @PathVariable double total_price, @PathVariable String payment) throws Exception {

       if(as.checkTotalAmountAgainstCart(total_price,userId)){
           List<AggiungiAlCarrello> cartItems = as.cercaCarrelloByIdUtente(userId);
           for(AggiungiAlCarrello addCart : cartItems){

                int orderId = getOrderId();
                long productId = addCart.getProdottiByIdProdotto().getId();
                double qty = addCart.getQuantità();
                cs.aggiungiCheckout(productId,userId,qty,total_price,payment,orderId);
           }
           return ResponseEntity.ok("ordine piazzato correttemente");
       }
       else{
           throw new Exception("Il totale non corrisponde");
       }


    }

    public int getOrderId(){
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

}
