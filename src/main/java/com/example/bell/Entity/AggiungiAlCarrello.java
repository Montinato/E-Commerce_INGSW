package com.example.bell.Entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "aggiungi_al_carrello", schema = "public", catalog = "postgres")
public class AggiungiAlCarrello {
    private int id;
    //private Integer idProdotto;
    //private Integer idUtente;
    private Double quantità;
    private Double prezzo;
    private Date dataAggiunta;

    private Prodotti prodottiByIdProdotto;
    private Utenti utentiByIdUtente;



    public AggiungiAlCarrello(int id, Double quantità, Double prezzo, Date dataAggiunta, Prodotti prodottiByIdProdotto, Utenti utentiByIdUtente) {
        this.id = id;
        //this.idProdotto = idProdotto;
        //this.idUtente = idUtente;
        this.quantità = quantità;
        this.prezzo = prezzo;
        this.dataAggiunta = dataAggiunta;
        this.prodottiByIdProdotto = prodottiByIdProdotto;
        this.utentiByIdUtente = utentiByIdUtente;
    }
    public AggiungiAlCarrello() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /*@Basic
    @Column(name = "id_prodotto")
    public Integer getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Integer idProdotto) {
        this.idProdotto = idProdotto;
    }

    @Basic
    @Column(name = "id_utente")
    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }*/
    @Basic
    @Column(name = "quantità")
    public Double getQuantità() {
        return quantità;
    }
    public void setQuantità(Double quantità) {
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
    @Column(name = "data_aggiunta")
    public Date getDataAggiunta() {
        return dataAggiunta;
    }

    public void setDataAggiunta(Date dataAggiunta) {
        this.dataAggiunta = dataAggiunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggiungiAlCarrello that = (AggiungiAlCarrello) o;
        return id == that.id &&
                Objects.equals(prodottiByIdProdotto.getId(), that.prodottiByIdProdotto.getId()) &&
                Objects.equals(utentiByIdUtente, that.utentiByIdUtente.getId()) &&
                Objects.equals(quantità, that.quantità) &&
                Objects.equals(prezzo, that.prezzo) &&
                Objects.equals(dataAggiunta, that.dataAggiunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantità, prezzo, dataAggiunta);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_prodotto", referencedColumnName = "id")
    public Prodotti getProdottiByIdProdotto() {
        return prodottiByIdProdotto;
    }
    public void setProdottiByIdProdotto(Prodotti prodottiByIdProdotto) {
        this.prodottiByIdProdotto = prodottiByIdProdotto;
    }
    @ManyToOne
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    public Utenti getUtentiByIdUtente() {
        return utentiByIdUtente;
    }
    public void setUtentiByIdUtente(Utenti utentiByIdUtente) {
        this.utentiByIdUtente = utentiByIdUtente;
    }

}
