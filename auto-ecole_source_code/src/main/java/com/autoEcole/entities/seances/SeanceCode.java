package com.autoEcole.entities.seances;

import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.condiats.Condidat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SeanceCode extends Seance {

    public SeanceCode(){}

    public SeanceCode(Long number, LocalDate date, List<String> cinCondidats, String cinIngenieur, String categorie, char type) {
        super(number, date, cinCondidats, cinIngenieur, categorie, type);
    }
}
