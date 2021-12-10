package com.autoEcole.gui.outputs.salaire;

import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;

import java.util.List;

public class SalaireOutput {
    private static final int WIDTH = 30;

    /**
     * Display the salaire menu
     *1: AFFICHER LE SALAIRE ACTUEL D'UN INGENEIUR
     * 2: MENU PRINCIPALE
     * */
    public static void salaireMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SALAIRE DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AFFICHER LE SALAIRE ACTUEL D'UN INGENIEUR");
        System.out.println("2: MENU PRINCIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the department name AFFICHER SALAIRE INGENIEUR
     * */
    public static void headerAfficherSalaireIngenieur(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-AFFICHER SALAIRE INGENIEUR-");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the department name DISPLAYING SALARY
     * */
    public static void headerDisplayingSalary(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("------DISPLAYING SALARY------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Displaying the salary of an engineer
     * */
    public static void displaySalaireIngenieur(Ingenieur ingenieur, float salary){

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println(ingenieur.getPrenom() + " " + ingenieur.getNom());
        System.out.println("SALAIRE: " + salary);
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

}
