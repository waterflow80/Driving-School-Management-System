package com.autoEcole.entities.seances;

import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.condiats.Condidat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Seance {
    protected Long number;
    protected LocalDate date;
    protected List<String> cinCondidats; // List of cin.s of candidates in this seance
    protected String cinIngenieur;
    protected String categorie; // A or B or C
    protected char type; // D: driving, C: code

    public Seance(){}

    public Seance(Long number, LocalDate date, List<String> cinCondidats, String cinIngenieur, String categorie, char type) {
        this.number = number;
        this.date = date;
        this.cinCondidats = cinCondidats;
        this.cinIngenieur = cinIngenieur;
        this.categorie = categorie;
        this.type = type;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getCinCondidats() {
        return cinCondidats;
    }

    public void setCinCondidats(List<String> cinCondidats) {
        this.cinCondidats = cinCondidats;
    }

    public String getCinIngenieur() {
        return cinIngenieur;
    }

    public void setCinIngenieur(String cinIngenieur) {
        this.cinIngenieur = cinIngenieur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
