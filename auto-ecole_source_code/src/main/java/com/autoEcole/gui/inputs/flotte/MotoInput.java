package com.autoEcole.gui.inputs.flotte;

import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.InputChecker;
import com.autoEcole.services.vehicules.MotoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MotoInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;

    /**
     * Ask the user to enter num immatriculation of the desired Moto
     * */
    public static Long chooseNumImmatriculationMoto(){
        Long num = 0L;
        System.out.println("NUM IMMATRICULATION MOTO: ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.existedMotoNumImmatriculation(num)){
                    System.out.println("! NUM IMMATRICULATION NOT FOUND !");
                    System.out.println("NUM IMMATRICULATION MOTO: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID NUM IMMATRICULATION !");
                System.out.println("NUM IMMATRICULATION MOTO: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedMotoNumImmatriculation(num));
        return num;
    }

    /**
     * Input the choice for the moto menu
     * 1: Ajouter une moto, 2: Supprimer une moto, 4: Afficher tous les motos
     * 3: Afficher une moto, 5: Menu principale
     * */
    public static String motoMenuChoice(){
        String choice = "";
        while (!InputChecker.validmotoMenuChoice(choice)){ //
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }


    /**
     * Input moto information from the user (to be completed to ll fields)
     * */
    public static Vehicule inputMoto(){
        Long numImmatriculation = inputNumImmatriculation();
        String marque = chooseMarqueMoto();
        //this section is missing some other attributes
        return new Vehicule(numImmatriculation,null,0,0,marque,true,0,null);
    }


    /**
     * Input num immatriculation of the moto from the user
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
     * Input the brand of the moto
     * */
    public static String chooseMarqueMoto(){
        String marque = "";
        MotoService.displayAllMarques();
        System.out.println("MARQUE: ");
        do {
            exceptionThrowed = false;
            try {
                marque = scanner.nextLine();
                if (!InputChecker.existedMarqueMoto(marque)){
                    System.out.println("! MARQUE NOT FOUND !");
                    System.out.println("MARQUE: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("MARQUE: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedMarqueMoto(marque));
        return marque;
    }
}
