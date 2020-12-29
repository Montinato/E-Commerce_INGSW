package com.example.bell.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "checkout", schema = "public", catalog = "postgres")
public class Checkout {
    private int id;
    private Long idProdotto;
    private Double qty;
    private Double prezzo;
    private Date ordineData;
    private Integer idUtente;
    private Integer idOrdine;
    private String paymentType;
    private String deliveryAddress;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_prodotto")
    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    @Basic
    @Column(name = "qty")
    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "prezzo")
    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    @Basic
    @Column(name = "ordine_data")
    public Date getOrdineData() {
        return ordineData;
    }

    public void setOrdineData(Date ordineData) {
        this.ordineData = ordineData;
    }

    @Basic
    @Column(name = "id_utente")
    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    @Basic
    @Column(name = "id_ordine")
    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    @Basic
    @Column(name = "payment_type")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "delivery_address")
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Checkout that = (Checkout) o;

        if (id != that.id) return false;
        if (idProdotto != null ? !idProdotto.equals(that.idProdotto) : that.idProdotto != null) return false;
        if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;
        if (prezzo != null ? !prezzo.equals(that.prezzo) : that.prezzo != null) return false;
        if (ordineData != null ? !ordineData.equals(that.ordineData) : that.ordineData != null) return false;
        if (idUtente != null ? !idUtente.equals(that.idUtente) : that.idUtente != null) return false;
        if (idOrdine != null ? !idOrdine.equals(that.idOrdine) : that.idOrdine != null) return false;
        if (paymentType != null ? !paymentType.equals(that.paymentType) : that.paymentType != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idProdotto != null ? idProdotto.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        result = 31 * result + (prezzo != null ? prezzo.hashCode() : 0);
        result = 31 * result + (ordineData != null ? ordineData.hashCode() : 0);
        result = 31 * result + (idUtente != null ? idUtente.hashCode() : 0);
        result = 31 * result + (idOrdine != null ? idOrdine.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        return result;
    }
}
