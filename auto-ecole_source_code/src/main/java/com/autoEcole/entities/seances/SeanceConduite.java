package com.autoEcole.entities.seances;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SeanceConduite extends Seance {
    /**The num immatriculation of the associated vehicle*/
    private Long numImmatriculation;

    public SeanceConduite() {

    }

    public SeanceConduite(Long number, LocalDate date, List<String> cinCondidats, String cinIngenieur, String categorie, char type, Long matricule) {
        super(number, date, cinCondidats, cinIngenieur, categorie, type);
        this.numImmatriculation = matricule;
    }

    public Long getNumImmatriculation() {
        return numImmatriculation;
    }

    public void setNumImmatriculation(Long numImmatriculation) {
        this.numImmatriculation = numImmatriculation;
    }
}

