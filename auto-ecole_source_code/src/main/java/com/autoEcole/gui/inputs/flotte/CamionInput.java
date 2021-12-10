package com.autoEcole.gui.inputs.flotte;

import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.InputChecker;
import com.autoEcole.services.vehicules.CamionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CamionInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Ask the user to enter num immatriculation of the desired Camion
     * */
    public static Long chooseNumImmatriculationCamion(){
        Long num = 0L;
        System.out.println("NUM IMMATRICULATION CAMION: ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.existedCamionNumImmatriculation(num)){
                    System.out.println("! NUM IMMATRICULATION NOT FOUND !");
                    System.out.println("NUM IMMATRICULATION CAMION: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID NUM IMMATRICULATION !");
                System.out.println("NUM IMMATRICULATION CAMION: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedCamionNumImmatriculation(num));
        return num;
    }


    /**
     * Input the choice for the camion menu
     * 1: Ajouter une camion, 2: Supprimer une moto, 4: Afficher tous les camions
     * 3: Afficher une camion, 5: Menu principale
     * */
    public static String camionMenuChoice(){
        String choice = "";
        while (!InputChecker.validcamionMenuChoice(choice)){ //
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input camion information from the user (to be completed to ll fields)
     * */
    public static Vehicule inputCamion(){
        Long numImmatriculation = inputNumImmatriculation();
        String marque = chooseMarqueCamion();
        //this section is missing some other attributes
        return new Vehicule(numImmatriculation,null,0,0,marque,true,0,null);
    }


    /**
     * Input num immatriculation of the camion from the user
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
     * Input the brand of the camion
     * */
    public static String chooseMarqueCamion(){
        String marque = "";
        CamionService.displayAllMarques();
        System.out.println("MARQUE: ");
        do {
            exceptionThrowed = false;
            try {
                marque = scanner.nextLine();
                if (!InputChecker.existedMarqueCamion(marque)){
                    System.out.println("! MARQUE NOT FOUND !");
                    System.out.println("MARQUE: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("MARQUE: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedMarqueCamion(marque));
        return marque;
    }
}
