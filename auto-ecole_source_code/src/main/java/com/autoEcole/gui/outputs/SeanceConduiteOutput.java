package com.autoEcole.gui.outputs;

import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.outputs.flotte.VehiculeOutput;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.IngenieurService;

import java.util.List;

public class SeanceConduiteOutput {
    private static final int WIDTH = 30;

    /**
     * Display options for seance conduite
     * 1: Ajouter une seance, 2: Supprimer une seance, 3: afficher tous les seances
     * 4: afficher une seance, 5: menu principale*/
    public static void seanceConduiteMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SEANCE CONDUITE DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UNE SEANCE");
        System.out.println("2: SUPPRIMER UNE SEANCE");
        System.out.println("3: AFFIHCER UNE SEANCE");
        System.out.println("4: AFFICHER TOUS LES SEANCES");
        System.out.println("5: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the department name Seance conduite Departmen
     * */
    public static void headerSeanceConduite(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SEANCE CONDUITE DEPARTMENT------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying all existing driving sessions including all details
     * */
    public static void displayAllSeancesConduiteAllDetails(List<SeanceConduite> seanceConduites){
        System.out.println("-- DISPLAYING ALL SEANCES CONDUITE --");
        List<Condidat> condidats;

        for (SeanceConduite s:seanceConduites){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("NUMBER: " + s.getNumber());
            System.out.println("DATE: " + s.getDate().toString());
            condidats = CondidatService.getAllCondidatsByCin(s.getCinCondidats()); //get all condidates associated with this seance
            System.out.print("CANDIDATES: [ ");
            for (Condidat c: condidats){
                System.out.print(c.getPrenom() + " , "); // displaying the list of candidates who are in the corresponding session
            }
            System.out.println("]");
            Ingenieur ingenieur = IngenieurService.getEngineerByCin(s.getCinIngenieur());
            System.out.println("ENGINEER: " + ingenieur.getPrenom());

            switch (s.getCategorie()){ //displaying the vehicle associated
                case "a": //moto
                    Vehicule moto = MotoReader.getVehiculeByNumImmatriculation(s.getNumImmatriculation());
                    if (moto != null) {
                        System.out.println("MOTO : | " + moto.getNumImmatriculation() + " | " + moto.getMarque() + " |");
                    }
                case "b": //voiture
                    Vehicule voiture = VoitureReader.getVehiculeByNumImmatriculation(s.getNumImmatriculation());
                    if (voiture != null) {
                        System.out.println("VOITURE : | " + voiture.getNumImmatriculation() + " | " + voiture.getMarque() +" |");
                    }
                case "c": //camion
                    Vehicule camion = CamionReader.getVehiculeByNumImmatriculation(s.getNumImmatriculation());
                    if (camion != null) {
                        System.out.println("CAMION : | " + camion.getNumImmatriculation() + " | " + camion.getMarque() +" |");
                    }
            }

            System.out.println("CATEGORIE: " + s.getCategorie().toUpperCase());
            switch (s.getType()){
                case 'd':
                    System.out.println("TYPE : CONDUITE" );
                    break;
                case 'c':
                    System.out.println("TYPE : CODE");
                    break;
            }

            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }


    /**
     * Display the title of the section: SUPPRIMER UNE SEANCE CONDUITE
     */
    public static void headerSupprimerSeanceConduite(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UNE SEANCE CONDUITE------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**Asking the User to input the number of the seance conduite
     * */
    public static void askForSeanceConduiteNumber(){
        System.out.println("NUMBER of SEANCE : ");
    }

    /**
     * Display the title of the section: AFFICHER UNE SEANCE
     * */
    public static void headerAfficherUneSeanceConduite(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AFFICHER UNE SEANCE------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the number of each seance code
     * */
    public static void displayAllSeancesConduiteNumber(List<SeanceConduite> seancesConduites){
        System.out.println("-- DISPLAYING ALL SEANCES CONDUITE's NUMBERS --");

        for (SeanceConduite s:seancesConduites){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("NUMBER: " + s.getNumber());
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }

    /**
     * Display one seance conduite with all details
     * */
    public static void displaySeanceCodeAllDetails(SeanceConduite seanceConduite){
        System.out.println("-- DISPLAYING ONE SEANCES CONDUITE --");
        List<Condidat> condidats;

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUMBER: " + seanceConduite.getNumber());
        System.out.println("DATE: " + seanceConduite.getDate().toString());
        condidats = CondidatService.getAllCondidatsByCin(seanceConduite.getCinCondidats()); //get all condidates associated with this seance
        System.out.print("CANCDIDATES: [ ");
        for (Condidat c: condidats){
            System.out.print(c.getPrenom() + " , "); // displaying the list of candidates who are in the corresponding session
        }
        System.out.println("]");
        Ingenieur ingenieur = IngenieurService.getEngineerByCin(seanceConduite.getCinIngenieur());
        System.out.println("ENGINEER: " + ingenieur.getPrenom());
        switch (seanceConduite.getCategorie()){ //displaying the vehicle associated
            case "a": //moto
                Vehicule moto = MotoReader.getVehiculeByNumImmatriculation(seanceConduite.getNumImmatriculation());
                if (moto != null) {
                    System.out.println("MOTO : | " + moto.getNumImmatriculation() + " | " + moto.getMarque() + " |");
                }
            case "b": //voiture
                Vehicule voiture = VoitureReader.getVehiculeByNumImmatriculation(seanceConduite.getNumImmatriculation());
                if (voiture != null) {
                    System.out.println("VOITURE : | " + voiture.getNumImmatriculation() + " | " + voiture.getMarque() +" |");
                }
            case "c": //camion
                Vehicule camion = CamionReader.getVehiculeByNumImmatriculation(seanceConduite.getNumImmatriculation());
                if (camion != null) {
                    System.out.println("CAMION : | " + camion.getNumImmatriculation() + " | " + camion.getMarque() +" |");
                }
        }
        System.out.println("CATEGORIE: " + seanceConduite.getCategorie().toUpperCase());
        switch (seanceConduite.getType()){
            case 'd':
                System.out.println("TYPE : CONDUITE" );
                break;
            case 'c':
                System.out.println("TYPE : CODE");
                break;
        }

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

}
