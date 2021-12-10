package com.autoEcole.gui.outputs;

import com.autoEcole.dao.engineer.EngineerReader;
import com.autoEcole.entities.ingenieurs.Ingenieur;

import java.util.List;

public class IngenieurOutput {

    private static final int WIDTH = 30;


    /**
     * Display the engineer choices list
     * 1:AJOUT, 2:SUPRESSION, 3:AFFICHAGE UN, 4: AFFIHCHAGE TOUS, 5; UPDATE, 5: MENU PRINCIPALE
     * */
    public static void engineerMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----INGENIEUR DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UN INGENIEUR");
        System.out.println("2: SUPPRIMER UN INGENIEUR");
        System.out.println("3: AFFIHCER UN INGENIEUR"); //The most important
        System.out.println("4: AFFICHER TOUS LES INGENIEUR");
        System.out.println("5: UPDATE UN INGENIEUR");
        System.out.println("6: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display Engineer information with all details
     */
    public static void engineerAllDetails(Ingenieur ingenieur){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("FIRSTNAME: " + ingenieur.getPrenom());
        System.out.println("LASTNAME: " + ingenieur.getNom());
        System.out.println("CIN: " + ingenieur.getCin());
        /*List<String[]> seancesDate = ingenieur.getSeancesDates();
        if (seancesDate != null) { //displaying the seances dates of the engineer
            System.out.println("ALL SEANCES DATES: ");
            System.out.print("| ");
            for (int i=0; i< seancesDate.size(); i++) {
                System.out.println(seancesDate.get(i) + " |");
            }
        }else
            System.out.println("NO SEANCES ASSIGNED");*/
        System.out.println();
        System.out.println("N° HOURS CODE SESSIONS: " + ingenieur.getNbHeuresCode());
        System.out.println("N° HOURS DRIVING SESSIONS: " + ingenieur.getNbHeuresConduite());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display Engineer information briefly; firstname, lastname, cin
     */
    public static void engineerFewDetails(Ingenieur ingenieur){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("FIRSTNAME: " + ingenieur.getPrenom());
        System.out.println("LASTNAME: " + ingenieur.getNom());
        System.out.println("CIN: " + ingenieur.getCin());
      /*  List<String[]> seancesDate = ingenieur.getSeancesDates();
        if (seancesDate != null) { //displaying the seances dates of the engineer
            System.out.println("ALL SEANCES DATES: ");
            System.out.print("| ");
            for (int i=0; i< seancesDate.size(); i++) {
                System.out.println(seancesDate.get(i) + " |");
            }
        }else
            System.out.println("NO SEANCES ASSIGNED");*/
        System.out.println();
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display List of Engineers information with all details
     */
    public static void engineersAllDetails(){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        if (!ingenieurs.isEmpty()) {
            System.out.println("----DISPLAYING ALL ENGINEERS---");
            for (Ingenieur ingenieur : ingenieurs) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("FIRSTNAME: " + ingenieur.getPrenom());
                System.out.println("LASTNAME: " + ingenieur.getNom());
                System.out.println("CIN: " + ingenieur.getCin());
  /*              List<String[]> seancesDate = ingenieur.getSeancesDates();
                if (seancesDate != null) { //displaying the seances dates of the engineer
                    System.out.println("ALL SEANCES DATES: ");
                    System.out.print("| ");
                    for (int i = 0; i < seancesDate.size(); i++) {
                        System.out.println(seancesDate.get(i) + " |");
                    }
                } else
                    System.out.println("NO SEANCES ASSIGNED");*/

                System.out.println();
                System.out.println("N° HOURS CODE SESSIONS: " + ingenieur.getNbHeuresCode());
                System.out.println("N° HOURS DRIVING SESSIONS: " + ingenieur.getNbHeuresConduite());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }
    }

    /**
     * Display List of Engineers information briefly; firstname, lastname, cin, n° of sessions
     */
    public static void engineersFewDetails(){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        if (!ingenieurs.isEmpty()) {
            System.out.println("----DISPLAYING ALL ENGINEERS---");
            for (Ingenieur ingenieur : ingenieurs) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("FIRSTNAME: " + ingenieur.getPrenom());
                System.out.println("LASTNAME: " + ingenieur.getNom());
                System.out.println("CIN: " + ingenieur.getCin());
/*                List<String[]> seancesDate = ingenieur.getSeancesDates();
                if (seancesDate != null) { //displaying the seances dates of the engineer
                    System.out.println("ALL SEANCES DATES: ");
                    System.out.print("| ");
                    for (int i = 0; i < seancesDate.size(); i++) {
                        System.out.println(seancesDate.get(i) + " |");
                    }
                } else
                    System.out.println("NO SEANCES ASSIGNED");*/
                System.out.println();
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }
    }

    /**
     * DISPLAY THE DEPARTMENT NAME -AJOUTER UN INGENIEUR
     * */
    public static void headerAjouterIngenieur(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----AJOUTER UN INGENIEUR------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * DISPLAY THE DEPARTMENT NAME -SUPPRIMER UN INGENIEUR
     * */
    public static void headerSupprimerIngenieur(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----SUPPRIMER UN INGENIEUR------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying a message asking for the cin of the engineer
     * */
    public static void askForCinIngenieur(){
        System.out.println("INGENIEUR CIN: ");
    }

    /**
     * DISPLAY THE DEPARTMENT NAME -AFFICHER UN INGENIEUR
     * */
    public static void headerAfficherIngenieur(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----AFFICHER UN INGENIEUR------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }
    }
