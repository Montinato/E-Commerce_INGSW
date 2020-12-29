package com.example.bell.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "utenti", schema = "public", catalog = "postgres")
public class Utenti {
    private int id;
    private String password;
    private String email;
    private String nome;
    private String cognome;
    private String tipo;

    private Collection<AggiungiAlCarrello> aggiungiAlCarrellosById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "cognome")
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utenti that = (Utenti) o;
        return id == that.id &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, nome, cognome, tipo);
    }


    @OneToMany(mappedBy = "utentiByIdUtente")
    @JsonIgnore
    public Collection<AggiungiAlCarrello> getAggiungiAlCarrellosById() {
        return aggiungiAlCarrellosById;
    }

    public void setAggiungiAlCarrellosById(Collection<AggiungiAlCarrello> aggiungiAlCarrellosById) {
        this.aggiungiAlCarrellosById = aggiungiAlCarrellosById;
    }

}
