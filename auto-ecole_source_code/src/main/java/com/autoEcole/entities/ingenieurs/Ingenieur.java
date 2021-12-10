package com.autoEcole.entities.ingenieurs;

import com.autoEcole.managemeent.Salaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ingenieur {
    private String cin;
    private String nom;
    private String prenom;
//    private boolean disponible; bad idea
    private List<LocalDate> seancesDates = new ArrayList<>(); //Stores the dates of seances (|day1|month1|year1|, |day2|month2|year2|,...)
    private double nbHeuresCode;
    private double nbHeuresConduite;

    public Ingenieur() {
    }

    /**
     * All fields except the list of seancesDates
     * */
    public Ingenieur(String cin, String nom, String prenom, double nbHeuresCode, double nbHeuresConduite) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.nbHeuresCode = nbHeuresCode;
        this.nbHeuresConduite = nbHeuresConduite;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<LocalDate> getSeancesDates() {
        return seancesDates;
    }

    public void setSeancesDates(List<LocalDate> seancesDates) {
        this.seancesDates = seancesDates;
    }

    /**
     * Adding a new date to the list of seances list
     * date format: {"day","month","year"}
     * */
    public void addSeanceDate(LocalDate localDate){
        this.seancesDates.add(localDate);
    }

    public double getNbHeuresCode() {
        return nbHeuresCode;
    }

    public void setNbHeuresCode(double nbHeuresCode) {
        this.nbHeuresCode = nbHeuresCode;
    }

    public double getNbHeuresConduite() {
        return nbHeuresConduite;
    }

    public void setNbHeuresConduite(double nbHeuresConduite) {
        this.nbHeuresConduite = nbHeuresConduite;
    }

}


