package com.autoEcole.gui.outputs.flotte;

import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.entities.vehicules.Vehicule;

import java.util.List;

public class VoitureOutput {

    private static final int WIDTH = 30;


    /**
     * Display options for voiture section
     * 1: Ajouter une voiture, 2: Supprimer une voiture, 3: afficher tous les voiture
     * 4: afficher une voiture, 5: menu principale*/
    public static void voitureMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------VOITURE DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UNE VOITURE");
        System.out.println("2: SUPPRIMER UNE VOITURE");
        System.out.println("3: AFFIHCER UNE VOITURE");
        System.out.println("4: AFFICHER TOUS LES VOITURES");
        System.out.println("5: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Displaying all voitures with all details
     * */
    public static void displayAllVoituresAllDetails(){
        List<Vehicule> voitures = VoitureReader.getAll();
        if (!voitures.isEmpty()){
            System.out.println("DISPLAYING ALL VOITURES");
            for (Vehicule v : voitures) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + v.getNumImmatriculation());
                System.out.println("MARQUE: " + v.getMarque());
                System.out.println("DISPONIBLE: " + v.isDisponible());
                if (v.getDateMiseEnService()!=null)
                    System.out.println("DATE MISE EN SERVICE: " + v.getDateMiseEnService().toString());
                else
                    System.out.println("DATE MISE EN SERVICE: NONE" );
                System.out.println("KILOMETRAGE TOTAL: " + v.getKilometrageTotal());
                System.out.println("NB KILOMETRES RESTANTS: " + v.getNbKilometresRestant());
                System.out.println("KILOMETRAGE MAX: "+ v.getKilometrageMax());
                if (v.getDateProchainEntretien()!=null)
                    System.out.println("DATE PROCHAIN ENTRETIEN: "+ v.getDateProchainEntretien().toString());
                else
                    System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO VOITURES AT THE MOMENT");
        }
    }

    /**
     * Displaying all voitures with the minimum of details: num immatriculation, marque, disbonible
     * */
    public static void displayAllVoituresFewDetails(){
        List<Vehicule> voitures = VoitureReader.getAll();
        if (!voitures.isEmpty()){
            System.out.println("DISPLAYING ALL VOITURES");
            for (Vehicule v : voitures) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("NUM IMMATRICULATION: " + v.getNumImmatriculation());
                System.out.println("MARQUE: " + v.getMarque());
                System.out.println("DISPONIBLE: " + v.isDisponible());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO VOITURES AT THE MOMENT");
        }
    }

    /**
     * Displaying onlu one voiture with the minimum of details
     * */
    public static void displayOneVoitureFewDetails(Vehicule voiture){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + voiture.getNumImmatriculation());
        System.out.println("MARQUE: " + voiture.getMarque());
        System.out.println("DISPONIBLE: " + voiture.isDisponible());
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
}

    /**
     * Displaying onlu one voiture with all details
     * */
    public static void displayOneVoitureAllDetails(Vehicule voiture){
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("NUM IMMATRICULATION: " + voiture.getNumImmatriculation());
        System.out.println("MARQUE: " + voiture.getMarque());
        System.out.println("DISPONIBLE: " + voiture.isDisponible());
        if (voiture.getDateMiseEnService()!=null)
            System.out.println("DATE MISE EN SERVICE: " + voiture.getDateMiseEnService().toString());
        else
            System.out.println("DATE MISE EN SERVICE: NONE" );
        System.out.println("KILOMETRAGE TOTAL: " + voiture.getKilometrageTotal());
        System.out.println("NB KILOMETRES RESTANTS: " + voiture.getNbKilometresRestant());
        System.out.println("KILOMETRAGE MAX: "+ voiture.getKilometrageMax());
        if (voiture.getDateProchainEntretien()!=null)
            System.out.println("DATE PROCHAIN ENTRETIEN: "+ voiture.getDateProchainEntretien().toString());
        else
            System.out.println("DATE PROCHAIN ENTRETIEN: NONE");
        for (int i = 0; i < WIDTH + 1; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display the section title AJOUTER UNE VOITURE
     * */
    public static void headerAjouterVoiture(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AJOUTER UNE VOITURE------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title SUPPRIMER UNE VOITURE
     * */
    public static void headerSupprimerVoiture(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UNE VOITURE------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the section title AFFICHER UNE VOITURE
     * */
    public static void headerAfficherUneVoiture(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AFFICHER UNE VOITURE------");
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
