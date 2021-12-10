package com.autoEcole.services.vehicules;

import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.dao.camion.CamionWriter;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.moto.MotoWriter;
import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.dao.voiture.VoitureWriter;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.flotte.CamionInput;
import com.autoEcole.gui.inputs.flotte.VoitureInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.MarqueOutput;
import com.autoEcole.gui.outputs.flotte.CamionOutput;
import com.autoEcole.gui.outputs.flotte.VehiculeOutput;
import com.autoEcole.gui.outputs.flotte.VoitureOutput;

import java.util.List;
import java.util.Objects;

public class VoitureService {


    /**
     * Input a new car information from the user and add it to the database (json file)
     * */
    public static void ajouterUneVoiture(){
        Vehicule voiture;
        VoitureOutput.headerAjouterVoiture(); //displays department name
        VoitureOutput.displayAllVoituresFewDetails();
        voiture = VoitureInput.inputVoiture();
        VoitureWriter.addVoiture(voiture);
    }

    /**
     * Delete Voiture by numImmatriculation
     * */
    public static void supprimerUneVoiture(){
        char response;
        List<Vehicule> allVoitures = VoitureReader.getAll();
        if (allVoitures.isEmpty())
            System.out.println("THERE ARE NO VOITURES AT THE MOMENT!");
        else {
            VoitureOutput.headerSupprimerVoiture();
            VoitureOutput.displayAllVoituresFewDetails();
            VoitureOutput.askForNumImmatriculation();
            final Long numImmatriculation = VoitureInput.chooseNumImmatriculationVoiture();
            Vehicule voiture = VoitureReader.getVehiculeByNumImmatriculation(numImmatriculation);
            VoitureOutput.displayOneVoitureFewDetails(voiture);
            response = CondidatInput.askForDeleteConfirmation();
            if (response == 'y'){
                allVoitures.removeIf(voiture1 ->voiture1.getNumImmatriculation().equals(numImmatriculation));
                VoitureWriter.addListVehicules(allVoitures);
            }else {
                CondidatOutput.operationAborted();
            }
        }
    }
    /**
     * Displaying all Voitures with few details
     * */
    public static void afficherTousLesVoitures(){
        if (VoitureReader.getAll().isEmpty())
            System.out.println("THERE ARE NO VOITURES IN THE GARAGE");
        else
            VoitureOutput.displayAllVoituresFewDetails();
    }

    /**
     * Ask the user for the num immatriculation of the voiture and displaying it
     * */
    public static void afficherUneVoiture(){
        Long numImmatriculation;
        List<Vehicule> allVoitures = VoitureReader.getAll();
        if (allVoitures.isEmpty())
            System.out.println("THERE ARE NO VOITURES IN THE GARAGE");
        else {
            VoitureOutput.headerAfficherUneVoiture();
            VoitureOutput.displayAllVoituresFewDetails();
            numImmatriculation = VoitureInput.inputNumImmatriculation();
            Vehicule voiture = VoitureReader.getVehiculeByNumImmatriculation(numImmatriculation);
            if (voiture !=null){
                VoitureOutput.displayOneVoitureAllDetails(voiture);
            }
        }
    }


    /**
     * Return the list of all voitures
     * */
    public static List<Vehicule> getAllVoitures(){
        return VoitureReader.getAll();
    }

    /**
     * Display all voitures with all details
     * */
    public static void displayAllVoituresWithAllDetails(){
        List<Vehicule> voitures = VoitureReader.getAll();
        if (!voitures.isEmpty()){
            System.out.println("--DISPLAYING ALL VOITURES--");
            for (Vehicule v: voitures){
                VehiculeOutput.displayVehiculeWithAllDetails(v);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL CARS IN THE GARAGE");
        }

    }

    /**
     * Display all voitures with the minimum of details
     * */
    public static void displayAllVoituresFewetails(){
        List<Vehicule> voitures = VoitureReader.getAll();
        if (!voitures.isEmpty()){
            System.out.println("--DISPLAYING ALL VOITURES--");
            for (Vehicule v: voitures){
                VehiculeOutput.displayVehiculeFewDetails(v);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL CARS IN THE GARAGE");
        }

    }

    /**
     * Return voiture by it's num immatriculation
     * */
    public static Vehicule getVoitureByNumImmatriculation(Long numImmatriculation){
        return VoitureReader.getVehiculeByNumImmatriculation(numImmatriculation);
    }

    /**
     * Changing the state of the attribute 'disponible' of the voiture;
     * if False set to True | if True set to False
     * */
    public static void changeDisponibiliteVoitureByNumImmatriculation(Long numImlatrculation){
        List<Vehicule> allVoitures = VoitureReader.getAll(); //list of all voitures
        if (allVoitures.isEmpty()){
            System.out.println("CANNOT FIND VOITURE; SORRY!");
        }else{
            for (Vehicule v: allVoitures){
                if (v.getNumImmatriculation().equals(numImlatrculation)){
                    if (v.isDisponible())
                        v.setDisponible(false);
                    else
                        v.setDisponible(true);
                    VoitureWriter.addListVehicules(allVoitures); //rewriting the updated list
                    break;
                }
            }
        }
    }

    /**
     * Displaying All available voitures Brands
     * */
    public static void displayAllMarques(){
        MarqueOutput.displayAllMarquesVoitures();
    }
}
