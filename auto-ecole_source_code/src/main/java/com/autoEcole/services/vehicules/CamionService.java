package com.autoEcole.services.vehicules;

import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.dao.camion.CamionWriter;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.moto.MotoWriter;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.flotte.CamionInput;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.MarqueOutput;
import com.autoEcole.gui.outputs.flotte.CamionOutput;
import com.autoEcole.gui.outputs.flotte.MotoOutput;
import com.autoEcole.gui.outputs.flotte.VehiculeOutput;

import java.util.List;

public class CamionService {


    /**
     * Input a new camion information from the user and add it to the database (json file)
     * */
    public static void ajouterUnCamion(){
        Vehicule camion;
        CamionOutput.headerAjouterCamion(); //displays department name
        CamionOutput.displayAllCamionsFewDetails();
        camion = CamionInput.inputCamion();
        CamionWriter.addCamion(camion);
    }

    /**
     * Delete Camion by numImmatriculation
     * */
    public static void supprimerUnCamion(){
        char response;
        List<Vehicule> allCamions = CamionReader.getAll();
        if (allCamions.isEmpty())
            System.out.println("THERE ARE NO CAMIONS AT THE MOMENT!");
        else {
            CamionOutput.headerSupprimerCamion();
            CamionOutput.displayAllCamionsFewDetails();
            CamionOutput.askForNumImmatriculation();
            final Long numImmatriculation = CamionInput.chooseNumImmatriculationCamion();
            Vehicule camion = CamionReader.getVehiculeByNumImmatriculation(numImmatriculation);
            CamionOutput.displayOneCamionFewDetails(camion);
            response = CondidatInput.askForDeleteConfirmation();
            if (response == 'y'){
                allCamions.removeIf(camion1 ->camion1.getNumImmatriculation().equals(numImmatriculation));
                CamionWriter.addListVehicules(allCamions);
            }else {
                CondidatOutput.operationAborted();
            }
        }
    }

    /**
     * Displaying all Camions with few details
     * */
    public static void afficherTousLesCamions(){
        if (CamionReader.getAll().isEmpty())
            System.out.println("THERE ARE NO CAMIONS IN THE GARAGE");
        else
            CamionOutput.displayAllCamionsFewDetails();
    }

    /**
     * Ask the user for the num immatriculation of the camion and displaying it
     * */
    public static void afficherUnCamion(){
        Long numImmatriculation;
        List<Vehicule> allCamions = CamionReader.getAll();
        if (allCamions.isEmpty())
            System.out.println("THERE ARE NO CAMIONS IN THE GARAGE");
        else {
            CamionOutput.headerAfficherUnCamion();
            CamionOutput.displayAllCamionsFewDetails();
            numImmatriculation = CamionInput.chooseNumImmatriculationCamion();
            Vehicule camion = CamionReader.getVehiculeByNumImmatriculation(numImmatriculation);
            if (camion !=null){
                CamionOutput.displayOneCamionAllDetails(camion);
            }
        }
    }


    /**
     * Return the list of all camions
     * */
    public static List<Vehicule> getAllCamions(){
        return CamionReader.getAll();
    }

    /**
     * Display all camions with all details
     * */
    public static void displayAllCamionsWithAllDetails(){
        List<Vehicule> camions = CamionReader.getAll();
        if (!camions.isEmpty()){
            System.out.println("--DISPLAYING ALL VOITURES--");
            for (Vehicule c: camions){
                VehiculeOutput.displayVehiculeWithAllDetails(c);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL CAMIONS IN THE GARAGE");
        }

    }

    /**
     * Display all camions with the minimum of details
     * */
    public static void displayAllCamionsFewDetails(){
        List<Vehicule> camions = CamionReader.getAll();
        if (!camions.isEmpty()){
            System.out.println("--DISPLAYING ALL VOITURES--");
            for (Vehicule c: camions){
                VehiculeOutput.displayVehiculeFewDetails(c);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL CAMIONS IN THE GARAGE");
        }

    }

    /**
     * Return the camion that corresponds to the num immatriculation
     * */
    public static Vehicule getCamionByNumImmatriculation(Long numImmatriculation){
        return CamionReader.getVehiculeByNumImmatriculation(numImmatriculation);
    }

    /**
     * Changing the state of the attribute 'disponible' of the camion;
     * if False set to True | if True set to False
     * */
    public static void changeDisponibiliteCamionByNumImmatriculation(Long numImlatrculation){
        List<Vehicule> allCamions = CamionReader.getAll(); //list of all camions
        if (allCamions.isEmpty()){
            System.out.println("CANNOT FIND CAMION; SORRY!");
        }else{
            for (Vehicule c: allCamions){
                if (c.getNumImmatriculation().equals(numImlatrculation)){
                    if (c.isDisponible())
                        c.setDisponible(false);
                    else
                        c.setDisponible(true);
                    CamionWriter.addListVehicules(allCamions); //rewriting the updated list
                    break;
                }
            }
        }
    }

    /**
     * Displaying All available camions Brands
     * */
    public static void displayAllMarques(){
        MarqueOutput.displayAllMarquesCamions();
    }

}
