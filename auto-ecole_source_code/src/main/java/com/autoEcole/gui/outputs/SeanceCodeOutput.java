package com.autoEcole.gui.outputs;

import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.IngenieurService;

import java.util.List;

public class SeanceCodeOutput {
    private static final int WIDTH = 30;


    /**
     * Display options for seance code
     * 1: Ajouter une seance, 2: Supprimer une seance, 3: afficher tous les seances
     * 4: afficher une seance, 5: menu principale*/
    public static void seanceCodeMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SEANCE CODE DEPARTMENT------");

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
     * Display the department name Seance Code Departmen
     * */
    public static void headerSeanceCode(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SEANCE CODE DEPARTMENT------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying all existing coding sessions including all details
     * */
    public static void displayAllSeancesCodeAllDetails(List<SeanceCode> seanceCodes){
        System.out.println("-- DISPLAYING ALL SEANCES CODE --");
        List<Condidat> condidats;

        for (SeanceCode s:seanceCodes){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("NUMBER: " + s.getNumber());
            System.out.println("DATE: " + s.getDate().toString());
            condidats = CondidatService.getAllCondidatsByCin(s.getCinCondidats()); //get all condidates associated with this seance
            System.out.print("CANCDIDATES: [ ");
            for (Condidat c: condidats){
                System.out.print(c.getPrenom() + " , "); // displaying the list of candidates who are in the corresponding session
            }
            System.out.println("]");
            Ingenieur ingenieur = IngenieurService.getEngineerByCin(s.getCinIngenieur());
            System.out.println("ENGINEER: " + ingenieur.getPrenom());
            System.out.printf("CATEGORIE: " + s.getCategorie().toUpperCase());
            switch (s.getType()){
                case 'd':
                    System.out.printf("TYPE : CONDUITE" );
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
     * Display one seance code with all details
     * */
    public static void displaySeanceCodeAllDetails(SeanceCode seanceCode){
        System.out.println("-- DISPLAYING ONE SEANCES CODE --");
        List<Condidat> condidats;

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUMBER: " + seanceCode.getNumber());
        System.out.println("DATE: " + seanceCode.getDate().toString());
        condidats = CondidatService.getAllCondidatsByCin(seanceCode.getCinCondidats()); //get all condidates associated with this seance
        System.out.print("CANCDIDATES: [ ");
        for (Condidat c: condidats){
            System.out.print(c.getPrenom() + " , "); // displaying the list of candidates who are in the corresponding session
        }
        System.out.println("]");
        Ingenieur ingenieur = IngenieurService.getEngineerByCin(seanceCode.getCinIngenieur());
        System.out.println("ENGINEER: " + ingenieur.getPrenom());
        System.out.printf("CATEGORIE: " + seanceCode.getCategorie().toUpperCase());
        switch (seanceCode.getType()){
            case 'd':
                System.out.printf("TYPE : CONDUITE" );
                break;
            case 'c':
                System.out.println("TYPE : CODE");
                break;
        }

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }



    /**
     * Display the title of the section: SUPPRIMER UNE SEANCE CODE
     */
    public static void headerSupprimerSeanceCode(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UNE SEANCE CODE------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**Asking the User to input the number of the seance code
     * */
    public static void askForSeanceCodeNumber(){
        System.out.println("NUMBER of SEANCE CODE TO DELETE: ");
    }

    /**
     * Display the title of the section: AFFICHER UNE SEANCE
     * */
    public static void headerAfficherUneSeanceCode(){
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
    public static void displayAllSeancesCodeNumber(List<SeanceCode> seanceCodes){
        System.out.println("-- DISPLAYING ALL SEANCES CODE's NUMBERS --");
        for (SeanceCode s:seanceCodes){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("NUMBER: " + s.getNumber());
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }
}
