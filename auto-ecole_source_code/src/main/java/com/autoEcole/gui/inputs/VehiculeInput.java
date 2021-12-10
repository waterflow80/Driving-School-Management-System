package com.autoEcole.gui.inputs;

import com.autoEcole.controllers.flotteControllers.CamionController;
import com.autoEcole.controllers.flotteControllers.MotoController;
import com.autoEcole.controllers.flotteControllers.VoitureController;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.services.vehicules.CamionService;
import com.autoEcole.services.vehicules.MotoService;
import com.autoEcole.services.vehicules.VoitureService;

import javax.jws.soap.SOAPBinding;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VehiculeInput {
  /*  private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;

    public static Vehicule voiture(){
     return null;
    }

    *//**
     * Ask the user to choose from existing cars by entering the car's num immatriculation
     **//*
    public static Vehicule chooseFromVoitures(){
        VoitureService.displayAllVoituresWithAllDetails();
        Long numImmatriculation = 0L;
        System.out.println("CHOOSE CAR BY NUM IMMATRICULATION: ");
        List<Vehicule> voitures = VoitureService.getAllVoitures();
        if (!voitures.isEmpty()){
            do {
                exceptionThrowed = false;
                try {
                    numImmatriculation = scanner.nextLong();
                    if (!InputChecker.validNumImmatriculation(numImmatriculation)){
                        System.out.println("! WRONG NUM IMMATRICULATION !");
                        System.out.println("IMMATRICULATION: ");
                        scanner.nextLine();
                    }
                }catch (InputMismatchException e){
                    System.out.println("! PLEASE ENTER A VALID NUM IMMATRICULATION !");
                    System.out.println("NUM IMMATRICULATION: ");
                    exceptionThrowed = true;
                    scanner.nextLine();
                }
            }while ( (exceptionThrowed) || !InputChecker.validNumImmatriculation(numImmatriculation));

            Vehicule voiture = VoitureService.getVoitureByNumImmatriculation(numImmatriculation);
            return voiture;
        }else {
            System.out.println("There are no cars avialable right now !");
            return null;
        }

    }

    *//**
     * Ask the user to choose from existing motos by entering the car's num immatriculation
     **//*
    public static Vehicule chooseFromMotos(){
        List<Vehicule> motos = MotoService.getAllMotos();
        MotoService.displayAllMotosWithAllDetails();
        Long numImmatriculation = 0L;
        System.out.println("CHOOSE MOTO BY NUM IMMATRICULATION: ");

        if (!motos.isEmpty()){
            do {
                exceptionThrowed = false;
                try {
                    numImmatriculation = scanner.nextLong();
                    if (!InputChecker.validNumImmatriculation(numImmatriculation)){
                        System.out.println("! WRONG NUM IMMATRICULATION !");
                        System.out.println("IMMATRICULATION: ");
                        scanner.nextLine();
                    }
                }catch (InputMismatchException e){
                    System.out.println("! PLEASE ENTER A VALID NUM IMMATRICULATION !");
                    System.out.println("NUM IMMATRICULATION: ");
                    exceptionThrowed = true;
                    scanner.nextLine();
                }
            }while ( (exceptionThrowed) || !InputChecker.validNumImmatriculation(numImmatriculation));

            Vehicule moto = MotoService.getMotoByNumImmatriculation(numImmatriculation);
            return moto;
        }else {
            System.out.println("There are no Bikes available right now");
            return null;
        }

    }

    *//**
     * Ask the user to choose from existing camions by entering the car's num immatriculation
     **//*
    public static Vehicule chooseFromCamions(){
        List<Vehicule> camions = CamionService.getAllCamions();
        CamionService.displayAllCamionsWithAllDetails();
        Long numImmatriculation = 0L;
        System.out.println("CHOOSE TRUCK BY NUM IMMATRICULATION: ");
        if (!camions.isEmpty()){
            do {
                exceptionThrowed = false;
                try {
                    numImmatriculation = scanner.nextLong();
                    if (!InputChecker.validNumImmatriculation(numImmatriculation)){
                        System.out.println("! WRONG NUM IMMATRICULATION !");
                        System.out.println("IMMATRICULATION: ");
                        scanner.nextLine();
                    }
                }catch (InputMismatchException e){
                    System.out.println("! PLEASE ENTER A VALID NUM IMMATRICULATION !");
                    System.out.println("NUM IMMATRICULATION: ");
                    exceptionThrowed = true;
                    scanner.nextLine();
                }
            }while ( (exceptionThrowed) || !InputChecker.validNumImmatriculation(numImmatriculation));
            Vehicule camion = CamionService.getCamionByNumImmatriculation(numImmatriculation);
            return camion;
        }else {
            System.out.println("There are no Trucks available right now !");
            return null;
        }

    }
*/


}
