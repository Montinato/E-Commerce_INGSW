package com.example.bell.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "prodotti", schema = "public", catalog = "postgres")
public class Prodotti {
    private int id;
    private String nome;
    private String immagine;
    private String descrizione;
    private Double prezzo;
    private Integer quantità;
    private String marca;
    private Collection<AggiungiAlCarrello> aggiungiAlCarrellosById;
    private Collection<Ordini> ordinisById;

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
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "immagine")
    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    @Basic
    @Column(name = "descrizione")
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
    @Column(name = "quantità")
    public Integer getQuantità() {
        return quantità;
    }

    public void setQuantità(Integer quantità) {
        this.quantità = quantità;
    }

    @Basic
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotti that = (Prodotti) o;
        return id == that.id &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(immagine, that.immagine) &&
                Objects.equals(descrizione, that.descrizione) &&
                Objects.equals(prezzo, that.prezzo) &&
                Objects.equals(quantità, that.quantità) &&
                Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, immagine, descrizione, prezzo, quantità, marca);
    }


    @OneToMany(mappedBy = "prodottiByIdProdotto")
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Collection<AggiungiAlCarrello> getAggiungiAlCarrellosById() {
        return aggiungiAlCarrellosById;
    }
    public void setAggiungiAlCarrellosById(Collection<AggiungiAlCarrello> aggiungiAlCarrellosById) {
        this.aggiungiAlCarrellosById = aggiungiAlCarrellosById;
    }
    @OneToMany(mappedBy = "prodottiByIdProdotto")
    @JsonIgnore
    public Collection<Ordini> getOrdinisById() {
        return ordinisById;
    }
    public void setOrdinisById(Collection<Ordini> ordinisById) {
        this.ordinisById = ordinisById;
    }
}
