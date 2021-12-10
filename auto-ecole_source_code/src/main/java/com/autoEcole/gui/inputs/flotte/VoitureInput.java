package com.autoEcole.gui.inputs.flotte;

import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.InputChecker;
import com.autoEcole.services.vehicules.VoitureService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VoitureInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Ask the user to enter num immatriculation of the desired Voiture
     * */
    public static Long chooseNumImmatriculationVoiture(){
        Long num = 0L;
        System.out.println("NUM IMMATRICULATION VOITURE: ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.existedVoitureNumImmatriculation(num)){
                    System.out.println("! NUM IMMATRICULATION NOT FOUND !");
                    System.out.println("NUM IMMATRICULATION MOTO: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID NUM IMMATRICULATION !");
                System.out.println("NUM IMMATRICULATION VOITURE: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedVoitureNumImmatriculation(num));
        return num;
    }

    /**
     * Input the choice for the voiture menu
     * 1: Ajouter une voiture, 2: Supprimer une voiture, 4: Afficher tous les voitures
     * 3: Afficher une voiture, 5: Menu principale
     * */
    public static String voitureMenuChoice(){
        String choice = "";
        while (!InputChecker.validvoitureMenuChoice(choice)){ //
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input voiture information from the user (to be completed to ll fields)
     * */
    public static Vehicule inputVoiture(){
        Long numImmatriculation = inputNumImmatriculation();
        String marque = chooseMarqueVoiture();
        //this section is missing some other attributes
        return new Vehicule(numImmatriculation,null,0,0,marque,true,0,null);
    }


    /**
     * Input num immatriculation of the voiture from the user
     * */
    public static Long inputNumImmatriculation(){
        Long num = 0L;
        System.out.println("NUM IMMATRICULATION (6 digits): ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.validNumImmatriculation(num)){
                    System.out.println("! PLEASE ENTER A VALID NUM IMMATRICULATION !");
                    System.out.println("NUM IMMATRICULATION (6 digits)");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("NUM IMMATRICULATION (6 digits): ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validNumImmatriculation(num));
        return num;
    }

    /**
     * Input the brand of the voiture
     * */
    public static String chooseMarqueVoiture(){
        String marque = "";
        VoitureService.displayAllMarques();
        System.out.println("MARQUE: ");
        do {
            exceptionThrowed = false;
            try {
                marque = scanner.nextLine();
                if (!InputChecker.existedMarqueVoiture(marque)){
                    System.out.println("! MARQUE NOT FOUND !");
                    System.out.println("MARQUE: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("MARQUE: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedMarqueVoiture(marque));
        return marque;
    }
}
