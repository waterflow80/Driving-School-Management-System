package com.autoEcole.services.vehicules;

import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.moto.MotoWriter;
import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.dao.voiture.VoitureWriter;
import com.autoEcole.entities.marqueVehicule.Marques;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.inputs.flotte.VoitureInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.MainOutput;
import com.autoEcole.gui.outputs.MarqueOutput;
import com.autoEcole.gui.outputs.flotte.MotoOutput;
import com.autoEcole.gui.outputs.flotte.VehiculeOutput;
import com.autoEcole.gui.outputs.flotte.VoitureOutput;

import java.util.List;

public class MotoService {

    /**
     * Return the list of all Motos
     * */
    public static List<Vehicule> getAllMotos(){
        return MotoReader.getAll();
    }

    /**
     * Display all Motos with all details
     * */
    public static void displayAllMotosWithAllDetails(){
        List<Vehicule> motos = MotoReader.getAll();
        if (!motos.isEmpty()){
            for (Vehicule m: motos){
                VehiculeOutput.displayVehiculeWithAllDetails(m);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL MOTOS IN THE GARAGE");
        }

    }

    /**
     * Display all Motos with the minimum of the details
     * */
    public static void displayAllMotosFewDetails(){
        List<Vehicule> motos = MotoReader.getAll();
        if(!motos.isEmpty()){
            System.out.println("--DISPLAYING ALL MOTOS--");
            for (Vehicule m: motos){
                VehiculeOutput.displayVehiculeFewDetails(m);
            }
        }else {
            System.out.println("THERE ARE NO ACTUAL MOTOS IN THE GARAGE");
        }

    }


    /**
     * Return Moto by it's num Immatriculation
     * */
    public static Vehicule getMotoByNumImmatriculation(Long numImmatriculation){
        return MotoReader.getVehiculeByNumImmatriculation(numImmatriculation);
    }

    /**
     * Input a new moto information from the user and add it to the database (json file)
     * */
    public static void ajouterUneMoto(){
        Vehicule moto;
        MotoOutput.headerAjouterMoto(); //displays department name
        MotoOutput.displayAllMotosFewDetails();
        moto = MotoInput.inputMoto();
        MotoWriter.addMoto(moto);
    }

    /**
     * Delete Moto by numImmatriculation
     * */
    public static void supprimerUneMoto(){
        char response;
        List<Vehicule> allMotos = MotoReader.getAll();
        if (allMotos.isEmpty())
            System.out.println("THERE ARE NO MOTOS AT THE MOMENT!");
        else {
            MotoOutput.headerSupprimerMoto();
            MotoOutput.displayAllMotosFewDetails();
            MotoOutput.askForNumImmatriculation();
            final Long numImmatriculation = MotoInput.chooseNumImmatriculationMoto();
            Vehicule moto = MotoReader.getVehiculeByNumImmatriculation(numImmatriculation);
            MotoOutput.displayOneMotoFewDetails(moto);
            response = CondidatInput.askForDeleteConfirmation();
            if (response == 'y'){
                allMotos.removeIf(moto1 ->moto1.getNumImmatriculation().equals(numImmatriculation));
                MotoWriter.addListVehicules(allMotos);
            }else {
                CondidatOutput.operationAborted();
            }
        }
    }

    /**
     * Displaying all Motos with few details
     * */
    public static void afficherTousLesMotos(){
        if (MotoReader.getAll().isEmpty())
            System.out.println("THERE ARE NO MOTOS IN THE GARAGE");
        else
            MotoOutput.displayAllMotosFewDetails();
    }

    /**
     * Ask the user for the num immatriculation of the moto and displaying it
     * */
    public static void afficherUneMoto(){
        Long numImmatriculation;
        List<Vehicule> motos = MotoReader.getAll();
        if (motos.isEmpty())
            System.out.println("THERE ARE NO MOTOS IN THE GARAGE");
        else {
            MotoOutput.headerAfficherUneMoto();
            MotoOutput.displayAllMotosFewDetails();
            numImmatriculation = MotoInput.chooseNumImmatriculationMoto();
            Vehicule moto = MotoReader.getVehiculeByNumImmatriculation(numImmatriculation);
            if (moto !=null){
                MotoOutput.displayOneVoitureAllDetails(moto);
            }else {
                System.out.println("MOTO NOT FOUND!");
            }
        }
    }

    /**
     * Changing the state of the attribute 'disponible' of the moto;
     * if False set to True | if True set to False
     * */
    public static void changeDisponibiliteMotoByNumImmatriculation(Long numImlatrculation){
        List<Vehicule> allMotos = MotoReader.getAll(); //list of all motos
        if (allMotos.isEmpty()){
            System.out.println("CANNOT FIND MOTO; SORRY!");
        }else{
            for (Vehicule m: allMotos){
                if (m.getNumImmatriculation().equals(numImlatrculation)){
                    if (m.isDisponible())
                        m.setDisponible(false);
                    else
                        m.setDisponible(true);
                    MotoWriter.addListVehicules(allMotos); //rewriting the updated list
                    break;
                }
            }
        }
    }

    /**
     * Displaying All available motos Brands
     * */
    public static void displayAllMarques(){
        MarqueOutput.displayAllMarquesMotos();
    }
}
