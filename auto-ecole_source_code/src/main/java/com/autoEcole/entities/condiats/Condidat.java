package com.autoEcole.entities.condiats;

import com.autoEcole.managemeent.Prix;

import java.time.LocalDate;
import java.util.Date;

public class Condidat {
    private String  cin;
    private String nom;
    private String prenom;
    private int age;
    private int phoneNumber;
    private char categorie;
    private int nbSeances = 0;
    private double montantPayeCode =0;
    private double montantPayeConduite =0;
    private LocalDate dateExamen;
    private boolean examenPayee = false;

    public Condidat(String cin, String nom, String prenom, int age, int numTel, char categorie, double montantPayeCode,
                    double montantPayeConduite, LocalDate dateExamen, boolean examenPayee) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.phoneNumber = numTel;
        this.categorie = categorie;
        this.montantPayeCode = montantPayeCode;
        this.montantPayeConduite = montantPayeConduite;
        this.dateExamen = dateExamen;
        this.examenPayee = examenPayee;
    }

    public Condidat() {
    }

    public Condidat(String cin, String nom, String prenom, int age, int numTel, char categorie) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.phoneNumber = numTel;
        this.categorie = categorie;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getCategorie() {
        return categorie;
    }

    public void setCategorie(char categorie) {
        this.categorie = categorie;
    }

    public int getNbSeances() {
        return nbSeances;
    }

    public void setNbSeances(int nbSeances) {
        this.nbSeances = nbSeances;
    }

    public double getMontantPayeCode() {
        return montantPayeCode;
    }

    public void setMontantPayeCode(double montantPayeCode) {
        this.montantPayeCode = montantPayeCode;
    }

    public double getMontantPayeConduite() {
        return montantPayeConduite;
    }

    public void setMontantPayeConduite(double montantPayeConduite) {
        this.montantPayeConduite = montantPayeConduite;
    }

    public LocalDate getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(LocalDate dateExamen) {
        this.dateExamen = dateExamen;
    }

    public boolean isExamenPayee() {
        return examenPayee;
    }

    public void setExamenPayee(boolean examenPayee) {
        this.examenPayee = examenPayee;
    }



    public void incrementNbSeances(){
        this.nbSeances ++;
    }
}
