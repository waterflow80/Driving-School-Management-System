package com.autoEcole.gui.outputs.flotte;

import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.vehicules.Vehicule;

import java.util.List;

public class MotoOutput {
    private static final int WIDTH = 30;


    /**
     * Display options for moto section
     * 1: Ajouter une moto, 2: Supprimer une moto, 3: afficher tous les motos
     * 4: afficher une moto, 5: menu principale*/
    public static void motoMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------MOTO DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UNE MOTO");
        System.out.println("2: SUPPRIMER UNE MOTO");
        System.out.println("3: AFFIHCER UNE MOTO");
        System.out.println("4: AFFICHER TOUS LES MOTOS");
        System.out.println("5: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title AJOUTER UNE MOTO
     * */
    public static void headerAjouterMoto(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AJOUTER UNE MOTO------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying all motos with all details
     * */
    public static void displayAllMotosAllDetails(){
        List<Vehicule> motos = MotoReader.getAll();
        if (!motos.isEmpty()){
            System.out.println("DISPLAYING ALL MOTOS");
            for (Vehicule m : motos) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + m.getNumImmatriculation());
                System.out.println("MARQUE: " + m.getMarque());
                System.out.println("DISPONIBLE: " + m.isDisponible());
                if (m.getDateMiseEnService()!=null)
                    System.out.println("DATE MISE EN SERVICE: " + m.getDateMiseEnService().toString());
                else
                    System.out.println("DATE MISE EN SERVICE: NONE" );
                System.out.println("KILOMETRAGE TOTAL: " + m.getKilometrageTotal());
                System.out.println("NB KILOMETRES RESTANTS: " + m.getNbKilometresRestant());
                System.out.println("KILOMETRAGE MAX: "+ m.getKilometrageMax());
                if (m.getDateProchainEntretien()!=null)
                    System.out.println("DATE PROCHAIN ENTRETIEN: "+ m.getDateProchainEntretien().toString());
                else
                    System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO MOTOS AT THE MOMENT");
        }
    }

    /**
     * Displaying all motos with the minimum of details: num immatriculation, marque, disbonible
     * */
    public static void displayAllMotosFewDetails(){
        List<Vehicule> motos = MotoReader.getAll();
        if (!motos.isEmpty()){
            System.out.println("DISPLAYING ALL MOTOS");
            for (Vehicule m : motos) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + m.getNumImmatriculation());
                System.out.println("MARQUE: " + m.getMarque());
                System.out.println("DISPONIBLE: " + m.isDisponible());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO MOTOS AT THE MOMENT");
        }
    }

    /**
     * Displaying onlu one moto with the minimum of details
     * */
    public static void displayOneMotoFewDetails(Vehicule moto){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + moto.getNumImmatriculation());
        System.out.println("MARQUE: " + moto.getMarque());
        System.out.println("DISPONIBLE: " + moto.isDisponible());
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Displaying onlu one moto with all details
     * */
    public static void displayOneVoitureAllDetails(Vehicule moto){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + moto.getNumImmatriculation());
        System.out.println("MARQUE: " + moto.getMarque());
        System.out.println("DISPONIBLE: " + moto.isDisponible());
        if (moto.getDateMiseEnService()!=null)
            System.out.println("DATE MISE EN SERVICE: " + moto.getDateMiseEnService().toString());
        else
            System.out.println("DATE MISE EN SERVICE: NONE" );
        System.out.println("KILOMETRAGE TOTAL: " + moto.getKilometrageTotal());
        System.out.println("NB KILOMETRES RESTANTS: " + moto.getNbKilometresRestant());
        System.out.println("KILOMETRAGE MAX: "+ moto.getKilometrageMax());
        if (moto.getDateProchainEntretien()!=null)
            System.out.println("DATE PROCHAIN ENTRETIEN: "+ moto.getDateProchainEntretien().toString());
        else
            System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display the section title SUPPRIMER UNE MOTO
     * */
    public static void headerSupprimerMoto(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UNE MOTO------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title AFFICHER UNE MOTO
     * */
    public static void headerAfficherUneMoto(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AFFICHER UNE MOTO------");
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
