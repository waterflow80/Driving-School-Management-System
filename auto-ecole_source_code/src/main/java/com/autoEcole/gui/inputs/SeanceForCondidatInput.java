package com.autoEcole.gui.inputs;

import com.autoEcole.controllers.ingenieurControllers.IngenieurController;
import com.autoEcole.controllers.seanceControllers.SeanceCodeController;
import com.autoEcole.controllers.seanceControllers.SeanceConduiteController;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.services.IngenieurService;
import com.autoEcole.services.NumberGeneratorService;
import com.autoEcole.services.SeanceCodeService;
import com.autoEcole.services.SeanceConduiteService;

import java.time.LocalDate;
import java.util.*;

/**
 * This section will be used when we want to create a session while we are creating a candidate
 * and associate it to this condidate
 * */
public class SeanceForCondidatInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Input Seance from user
     * */
    /*public static Seance seanceWithoutCondidat(char category){
        Seance seance;
        char type = SeanceInput.type(); // C: CODE, D: CONDUITE
        switch (type){
            case 'd': //Driving Session(Conduite)
                SeanceConduiteService.displayAllSeancesWithoutDetails();
                seance = seanceConduiteWithoutCondidat(category);
                return seance;
            case 'c': //Code Session(Code)
                SeanceCodeService.displayAllSeancesWithoutDetails();
                seance = seanceCodeWithoutCondidat(category);
                return seance;
        }
        return null;
    }*/

    /**
     * Input Code session from user
     * */
    /*public static Seance seanceCodeWithoutCondidat(char category1){
        Seance seance;
        switch (category1){
            case 'a': //A Category
                seance = seanceCodeAWithoutCondidat();
                return seance;
            case 'b':
                seance = seanceCodeBWithoutCondidat();
                return seance;
            case 'c':
                seance = seanceCodeCWithoutCondidat();
                return seance;
        }
        return null;
    }

    *//**
     * Input Driving session from user
     * *//*
    public static Seance seanceConduiteWithoutCondidat(char category1){
        Seance seance;
        switch (category1){
            case 'a': //A Category
                seance = seanceConduiteAWithoutCondidat();  //A
                return seance;
            case 'b':
                seance = seanceConduiteBWithoutCondidat(); //B
                return seance;
            case 'c':
                seance = seanceConduiteCWithoutCondidat(); //C
                return seance;
        }
        return null;
    }*/

    /**
     * Input driving session category A's information from the user, without adding condidat
     * Vehicles are Motos
     */
    /*public static Seance seanceConduiteAWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        String cinIngenieur = "";
        LocalDate date = SeanceInput.seanceDate();
//        int number = SeanceInput.seanceNumber();
        Long number= NumberGeneratorService.getSeanceNumber();
        Long numImmatriculationMoto; // moto because the type of the driving session is A


        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }
        numImmatriculationMoto = MotoInput.chooseNumImmatriculationMoto();
        if (moto != null){
            seance = new SeanceConduite(number,date,null,cinIngenieur,"a",'d',moto.getNumImmatriculation());
        }else
            seance = new SeanceConduite(number,date,null,cinIngenieur,"a",'d',null);

        return seance;
    }

    *//**
     * Input driving session category B's information from the user, without adding condidat
     * Vehicles are Cars
     *//*
    public static Seance seanceConduiteBWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        String cinIngenieur = "";
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule voiture; // Voiture because the type of the driving session is A

        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }
        voiture = VehiculeInput.chooseFromVoitures();
        if (voiture != null)
            seance = new SeanceConduite(number,date,null,cinIngenieur,"b",'d',voiture.getNumImmatriculation());
        else
            seance = new SeanceConduite(number,date,null,cinIngenieur,"b",'d',null);
        return seance;
    }

    *//**
     * Input driving session category B's information from the user, without adding condidat
     * Vehicles are Camions
     *//*
    public static Seance seanceConduiteCWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        String cinIngenieur = "";
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule camion; // Voiture because the type of the driving session is A

        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }
        camion = VehiculeInput.chooseFromCamions();
        if (camion != null)
            seance = new SeanceConduite(number,date,null,cinIngenieur,"c",'d',camion.getNumImmatriculation());
        else
            seance = new SeanceConduite(number,date,null,cinIngenieur,"c",'d',null);
        return seance;
    }


    *//**
     * Input code session category A's information from the user, without adding condidat
     * No Vehicles
     *//*
    public static Seance seanceCodeAWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        String cinIngenieur = "";
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();

        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }

        seance = new SeanceCode(number,date,null,cinIngenieur,"a",'c');
        return seance;
    }

    *//**
     * Input code session category B's information from the user.
     * No Vehicles
     *//*
    public static Seance seanceCodeBWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        String cinIngenieur = "";
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();

        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }

        seance = new SeanceCode(number,date,null,cinIngenieur,"b",'c');
        return seance;
    }

    *//**
     * Input code session category B's information from the user.
     * No Vehicles
     *//*
    public static Seance seanceCodeCWithoutCondidat(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        Ingenieur ingenieur =null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        String cinIngenieur = "";

        char ae = IngenieurInput.askToAddNewEngineer();// Ask the user if he wants to add an engineer to the session
        if (ae == 'y'){
            ingenieurs = IngenieurService.getAllEngineers();
            if (ingenieurs.isEmpty())
                System.out.println("There are no Engineers to add at this moment !");
            else{
                IngenieurOutput.engineersFewDetails(ingenieurs);
                cinIngenieur = IngenieurInput.cin(); //getting the cin of teh engineer for the user
            }
        }

        seance = new SeanceCode(number,date,null,cinIngenieur,"c",'c');
        return seance;
    }*/


}
