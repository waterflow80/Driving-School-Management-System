package com.autoEcole.gui.outputs;

import com.autoEcole.Main;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.marqueVehicule.Marques;

public class MainOutput {
    private static final int WIDTH = 30;


    /*
     * Display the title of the section: WELCOME AUTO ECOLE
     * */
    public static void mainMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----WELCOME AUTO ECOLE-----");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: GESTION DES CONDIDATS");
        System.out.println("2: GESTION DES SEANCES");
        System.out.println("3: GESTION DU FLOTTE"); //The most important
        System.out.println("4: GESTION DES INGENIEURS");
        System.out.println("5: GESTION DES SALAIRES");
        System.out.println("6: EXIT");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");

    }









}

