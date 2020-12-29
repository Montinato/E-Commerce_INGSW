package com.example.bell.Repositories;

import com.example.bell.Entity.Checkout;
import org.hibernate.annotations.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Integer> {

    List<Checkout> findCheckoutsByIdUtente(int userId);

    Checkout findCheckoutsByIdOrdine(int ordineId);
}
