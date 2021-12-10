package com.autoEcole.gui.outputs;

import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.entities.marqueVehicule.Marques;

public class MarqueOutput {
    private static final int WIDTH = 30;

    /**
     * Displaying all available brands of motos
     * */
    public static void displayAllMarquesMotos(){
        Marques marquesMotos = MotoReader.getAllMarquesMotos();
        System.out.println("-- ALL MOTO BRANDS--");
        for (String m:marquesMotos.getMarques()){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("||||--" + m + "--||||");
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }

    /**
     * Displaying all available brands of camions
     * */
    public static void displayAllMarquesCamions(){
        Marques marquesCamions = CamionReader.getAllMarquesCamions();
        System.out.println("-- ALL CAMION BRANDS--");
        for (String m:marquesCamions.getMarques()){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("||||--" + m + "--||||");
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }

    /**
     * Displaying all available brands of voitures
     * */
    public static void displayAllMarquesVoitures(){
        Marques marquesVoitures = VoitureReader.getAllMarquesVoitures();
        System.out.println("-- ALL CAMION BRANDS--");
        for (String m:marquesVoitures.getMarques()){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("||||--" + m + "--||||");
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }

}
