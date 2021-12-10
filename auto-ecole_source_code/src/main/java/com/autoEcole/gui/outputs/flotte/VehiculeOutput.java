package com.autoEcole.gui.outputs.flotte;

import com.autoEcole.entities.vehicules.Vehicule;

public class VehiculeOutput {
    private static final int WIDTH = 30;

    /**
     * Display a Vehicle with associated details
     * */
    public static void displayVehiculeWithAllDetails(Vehicule vehicule){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");

        System.out.println("NUM IMMATRICULATION: " + vehicule.getNumImmatriculation());
        System.out.println("MARQUE: " + vehicule.getMarque());
        System.out.println("DISPONIBILITÉ: " + vehicule.isDisponible());
        if (vehicule.getDateMiseEnService()!=null)
            System.out.println("DATE MISE EN SERVICE: " + vehicule.getDateMiseEnService().toString());
        else
            System.out.println("DATE MISE EN SERVICE: NONE" );
        System.out.println("KILOMETRAGE TOTAL " + vehicule.getKilometrageTotal());
        System.out.println("KILOMETRAGE MAXIMAL: " + vehicule.getKilometrageMax());
        System.out.println("NOMBRE DE KILOMETRES RESTANT: " + vehicule.getNbKilometresRestant());
        if (vehicule.getDateProchainEntretien()!=null)
            System.out.println("DATE PROCHAIN ENTRETIEN: "+ vehicule.getDateProchainEntretien().toString());
        else
            System.out.println("DATE PROCHAIN ENTRETIEN: NONE");


        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display vehicle with the minimum of details
     * */
    public static void displayVehiculeFewDetails(Vehicule vehicule){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + vehicule.getNumImmatriculation());
        System.out.println("MARQUE: " + vehicule.getMarque());
        System.out.println("DISPONIBILITÉ: " + vehicule.isDisponible());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }
}
