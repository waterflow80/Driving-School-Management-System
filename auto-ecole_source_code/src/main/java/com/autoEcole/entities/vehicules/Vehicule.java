package com.autoEcole.entities.vehicules;

import java.time.LocalDate;

public class Vehicule {
    private Long numImmatriculation;
    private LocalDate dateMiseEnService;
    private double kilometrageTotal;
    private double nbKilometresRestant;
    private String marque;
    private boolean disponible;
    private double kilometrageMax;
    private LocalDate dateProchainEntretien;

    public Vehicule() {
    }

    public Vehicule(Long numImmatriculation, LocalDate dateMiseEnService, double kilometrageTotal,
                    double nbKilometresRestant, String marque, boolean disponible, double kilometrageMAx,
                    LocalDate dateProchainEntretien) {
        this.numImmatriculation = numImmatriculation;
        this.dateMiseEnService = dateMiseEnService;
        this.kilometrageTotal = kilometrageTotal;
        this.nbKilometresRestant = nbKilometresRestant;
        this.marque = marque;
        this.disponible = disponible;
        this.kilometrageMax = kilometrageMAx;
        this.dateProchainEntretien = dateProchainEntretien;
    }

    public Long getNumImmatriculation() {
        return numImmatriculation;
    }

    public void setNumImmatriculation(Long numImmatriculation) {
        this.numImmatriculation = numImmatriculation;
    }

    public LocalDate getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(LocalDate dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public double getKilometrageTotal() {
        return kilometrageTotal;
    }

    public void setKilometrageTotal(double kilometrageTotal) {
        this.kilometrageTotal = kilometrageTotal;
    }

    public double getNbKilometresRestant() {
        return nbKilometresRestant;
    }

    public void setNbKilometresRestant(double nbKilometresRestant) {
        this.nbKilometresRestant = nbKilometresRestant;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getKilometrageMax() {
        return kilometrageMax;
    }

    public void setKilometrageMax(double kilometrageMax) {
        this.kilometrageMax = kilometrageMax;
    }

    public LocalDate getDateProchainEntretien() {
        return dateProchainEntretien;
    }

    public void setDateProchainEntretien(LocalDate dateProchainEntretien) {
        this.dateProchainEntretien = dateProchainEntretien;
    }
}
