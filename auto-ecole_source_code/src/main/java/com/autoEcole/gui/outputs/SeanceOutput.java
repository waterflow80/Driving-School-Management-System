package com.autoEcole.gui.outputs;

import com.autoEcole.controllers.ingenieurControllers.IngenieurController;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.services.IngenieurService;

public class SeanceOutput {

    private static final int WIDTH = 30;

    /**
     * Display the seance main menu where the user should choose between
     * code or conduite
     * */
    public static void seanceMainMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SEANCE DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: SEANCE CODE");
        System.out.println("2: SEANCE CONDUITE");
        System.out.println("3: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display Seance information without the corresponding Candidate's and the Engineer's
     */
    public static void displaySeanceWithoutDetails(Seance seance){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("*");
        System.out.print("\n");
        System.out.println("SEANCE NUMBER: " + seance.getNumber());
        System.out.println("SEANCE DATE: " + seance.getDate());
        System.out.println("TYPE" + seance.getCategorie());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("*");
        System.out.print("\n");
    }

    /**
     * Display Seance information including the corresponding Candidate and the Engineer
     */
    public static void displaySeanceWithAllDetails(Seance seance){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("*");
        System.out.print("\n");
        System.out.println("SEANCE NUMBER: " + seance.getNumber());
        System.out.println("SEANCE DATE: " + seance.getDate());
        System.out.println("TYPE" + seance.getCategorie());
        System.out.println("CONDIDATS: ");
        CondidatOutput.condidatsFewDetailsByCin(seance.getCinCondidats());
        Ingenieur ingenieur = IngenieurService.getEngineerByCin(seance.getCinIngenieur());
        if (ingenieur != null)
            System.out.println("Engineer: " + ingenieur.getPrenom());
        else
            System.out.println("Engineer: " + "None");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("*");
        System.out.print("\n");
    }
}
