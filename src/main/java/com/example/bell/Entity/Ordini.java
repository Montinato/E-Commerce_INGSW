package com.example.bell.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ordini", schema = "public", catalog = "postgres")
public class Ordini {
    private int id;
    private String idOrdine;
    private Integer quantità;
    private Double prezzo;
    private Date dataOrdine;
    private Integer stato;

    private Prodotti prodottiByIdProdotto;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_ordine")
    public String getIdOrdine() {
        return idOrdine;
    }
    public void setIdOrdine(String idOrdine) {
        this.idOrdine = idOrdine;
    }

    @Basic
    @Column(name = "quantità")
    public Integer getQuantità() {
        return quantità;
    }
    public void setQuantità(Integer quantità) {
        this.quantità = quantità;
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
    @Column(name = "data_ordine")
    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    @Basic
    @Column(name = "stato")
    public Integer getStato() {
        return stato;
    }

    public void setStato(Integer stato) {
        this.stato = stato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordini that = (Ordini) o;
        return id == that.id &&
                Objects.equals(idOrdine, that.idOrdine) &&
                Objects.equals(quantità, that.quantità) &&
                Objects.equals(prezzo, that.prezzo) &&
                Objects.equals(dataOrdine, that.dataOrdine) &&
                Objects.equals(stato, that.stato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idOrdine, quantità, prezzo, dataOrdine, stato);
    }

    @ManyToOne
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    public Prodotti getProdottiByIdProdotto() {
        return prodottiByIdProdotto;
    }
    public void setProdottiByIdProdotto(Prodotti prodottiByIdProdotto) {
        this.prodottiByIdProdotto = prodottiByIdProdotto;
    }
}
