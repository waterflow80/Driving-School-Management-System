package com.autoEcole.gui.outputs.flotte;

import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.entities.vehicules.Vehicule;

import java.util.List;

public class CamionOutput {

    private static final int WIDTH = 30;


    /**
     * Display options for camion section
     * 1: Ajouter une camion, 2: Supprimer une camion, 3: afficher tous les camion
     * 4: afficher une camion, 5: menu principale*/
    public static void camionMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------CAMION DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UNE CAMION");
        System.out.println("2: SUPPRIMER UNE CAMION");
        System.out.println("3: AFFIHCER UNE CAMION");
        System.out.println("4: AFFICHER TOUS LES CAMIONS");
        System.out.println("5: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying all camions with all details
     * */
    public static void displayAllCamionsAllDetails(){
        List<Vehicule> camions = CamionReader.getAll();
        if (!camions.isEmpty()){
            System.out.println("DISPLAYING ALL CAMIONS");
            for (Vehicule c : camions) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + c.getNumImmatriculation());
                System.out.println("MARQUE: " + c.getMarque());
                System.out.println("DISPONIBLE: " + c.isDisponible());
                if (c.getDateMiseEnService()!=null)
                    System.out.println("DATE MISE EN SERVICE: " + c.getDateMiseEnService().toString());
                else
                    System.out.println("DATE MISE EN SERVICE: NONE" );
                System.out.println("KILOMETRAGE TOTAL: " + c.getKilometrageTotal());
                System.out.println("NB KILOMETRES RESTANTS: " + c.getNbKilometresRestant());
                System.out.println("KILOMETRAGE MAX: "+ c.getKilometrageMax());
                if (c.getDateProchainEntretien()!=null)
                    System.out.println("DATE PROCHAIN ENTRETIEN: "+ c.getDateProchainEntretien().toString());
                else
                    System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO CAMIONS AT THE MOMENT");
        }
    }

    /**
     * Displaying all camions with the minimum of details: num immatriculation, marque, disbonible
     * */
    public static void displayAllCamionsFewDetails(){
        List<Vehicule> camions = CamionReader.getAll();
        if (!camions.isEmpty()){
            System.out.println("DISPLAYING ALL CAMIONS");
            for (Vehicule c : camions) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + c.getNumImmatriculation());
                System.out.println("MARQUE: " + c.getMarque());
                System.out.println("DISPONIBLE: " + c.isDisponible());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO CAMIONS AT THE MOMENT");
        }
    }

    /**
     * Displaying onlu one camion with the minimum of details
     * */
    public static void displayOneCamionFewDetails(Vehicule camion){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + camion.getNumImmatriculation());
        System.out.println("MARQUE: " + camion.getMarque());
        System.out.println("DISPONIBLE: " + camion.isDisponible());
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Displaying onlu one camion with all details
     * */
    public static void displayOneCamionAllDetails(Vehicule camion){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + camion.getNumImmatriculation());
        System.out.println("MARQUE: " + camion.getMarque());
        System.out.println("DISPONIBLE: " + camion.isDisponible());
        if (camion.getDateMiseEnService()!=null)
            System.out.println("DATE MISE EN SERVICE: " + camion.getDateMiseEnService().toString());
        else
            System.out.println("DATE MISE EN SERVICE: NONE" );
        System.out.println("KILOMETRAGE TOTAL: " + camion.getKilometrageTotal());
        System.out.println("NB KILOMETRES RESTANTS: " + camion.getNbKilometresRestant());
        System.out.println("KILOMETRAGE MAX: "+ camion.getKilometrageMax());
        if (camion.getDateProchainEntretien()!=null)
            System.out.println("DATE PROCHAIN ENTRETIEN: "+ camion.getDateProchainEntretien().toString());
        else
            System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display the section title AJOUTER UN CAMION
     * */
    public static void headerAjouterCamion(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AJOUTER UN CAMION------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title AFFICHER UN CAMION
     * */
    public static void headerAfficherUnCamion(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AFFICHER UN CAMION------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title SUPPRIMER UN CAMION
     * */
    public static void headerSupprimerCamion(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UN CAMION------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display a message asking for user to enter num immatriculation
     * */
    public static void askForNumImmatriculation(){
        System.out.println("NUM IMMATRICULATION: ");
    }

}
