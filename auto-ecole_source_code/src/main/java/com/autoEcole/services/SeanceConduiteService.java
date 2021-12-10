package com.autoEcole.services;

import com.autoEcole.dao.Seances.SeanceCodeReader;
import com.autoEcole.dao.Seances.SeanceCodeWriter;
import com.autoEcole.dao.Seances.SeanceConduiteReader;
import com.autoEcole.dao.Seances.SeanceConduiteWriter;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.gui.inputs.SeanceCodeInput;
import com.autoEcole.gui.inputs.SeanceConduiteInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.SeanceCodeOutput;
import com.autoEcole.gui.outputs.SeanceConduiteOutput;
import com.autoEcole.gui.outputs.SeanceOutput;
import com.autoEcole.services.vehicules.CamionService;
import com.autoEcole.services.vehicules.MotoService;
import com.autoEcole.services.vehicules.VoitureService;

import java.util.List;

public class SeanceConduiteService {

    /**
     * Display the list of Existing Seances with the corresponding Candidate and Engineer
     */
    public static void displayAllSeancesWithAllDetails(){
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        for (Seance s: seanceConduites){
            SeanceOutput.displaySeanceWithAllDetails(s);
        }
    }

    /**
     * Display the list of Existing Seances with the corresponding Candidate and Engineer
     */
    public static void displayAllSeancesWithoutDetails(){
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        for (Seance s: seanceConduites){
            SeanceOutput.displaySeanceWithoutDetails(s);
        }
    }

    /**
     * Saving the Seance Conduite to the file
     * */
    public static void addSeance(SeanceConduite seance){
        SeanceConduiteWriter.addSeanceConduite(seance);
    }

    /**
     * Ask the user to enter e new seance conduite and save it to the json file
     * */
    public static void ajouterSeanceConduite(){
        SeanceConduite seanceConduite;
        SeanceConduiteOutput.headerSeanceConduite();
        SeanceConduiteOutput.displayAllSeancesConduiteAllDetails(SeanceConduiteReader.getAll()); //Displaying all existing coding sessions
        seanceConduite = SeanceConduiteInput.seanceWithCondidats(); //Input session information from user
        if (seanceConduite != null){
            SeanceConduiteWriter.addSeanceConduite(seanceConduite);
        }

    }



    /**
     * Delete driving session from the database (json file)
     * */
    public static void supprimerSeanceConduite(){
        char response;
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll(); //Get the current list of all code session
        if (seanceConduites.isEmpty()){
            System.out.println("THERE ARE NO SEANCES CONDUITE AT THE MOMENT!");
        }else{
            SeanceConduiteOutput.headerSupprimerSeanceConduite();
            SeanceConduiteOutput.displayAllSeancesConduiteAllDetails(seanceConduites); //Displaying all seance code
            SeanceConduiteOutput.askForSeanceConduiteNumber();
            final Long number = SeanceConduiteInput.seanceConduiteNumber();
            SeanceConduite seanceConduite = SeanceConduiteReader.getSeanceByNumber(number);
            response = SeanceCodeInput.askForDeleteConfirmation();
            if (response == 'y'){
                switch (seanceConduite.getCategorie()){
                    case "a": // we will set the availability of the moto to true again
                        MotoService.changeDisponibiliteMotoByNumImmatriculation(seanceConduite.getNumImmatriculation());
                        break;
                    case "b": // we will set the availability of the voiture to true again
                        VoitureService.changeDisponibiliteVoitureByNumImmatriculation(seanceConduite.getNumImmatriculation());
                        break;
                    case "c": // we will set the availability of the voiture to true again
                        CamionService.changeDisponibiliteCamionByNumImmatriculation(seanceConduite.getNumImmatriculation());
                        break;
                }
                seanceConduites.removeIf(seanceConduite1 -> seanceConduite1.getNumber().equals(number));
                SeanceConduiteWriter.addListSeancesConduite(seanceConduites);
            }else{
                CondidatOutput.operationAborted(); //We borrowed this method from the condidat service
            }
        }

    }

    /**Display one session(all details)*/
    public static void afficherUneSeanceConduite(){
        Long number;
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        if (!seanceConduites.isEmpty()){
            SeanceConduiteOutput.headerAfficherUneSeanceConduite();
            SeanceConduiteOutput.displayAllSeancesConduiteNumber(seanceConduites);
            SeanceConduiteOutput.askForSeanceConduiteNumber();
            number = SeanceConduiteInput.seanceConduiteNumber();
            SeanceConduite seanceConduite = SeanceConduiteReader.getSeanceByNumber(number);
            if (seanceConduite!=null){
                SeanceConduiteOutput.displaySeanceCodeAllDetails(seanceConduite);
            }else {
                System.out.println("SEANCE NOT FOUND !");
            }
        }else {
            System.out.println("THERE ARE NO SEANCES CONSUITE AT THE MOMENT !");
        }

    }

    /**
     * Displaying all Seances conduite
     * */
    public static void afficherTousLesSeancesConduite(){
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        if (!seanceConduites.isEmpty()){
            SeanceConduiteOutput.displayAllSeancesConduiteAllDetails(seanceConduites);
        }else {
            System.out.println("THERE ARE NO ACTUAL SEANCES CONDUITE AT THE MOMENT");
        }
    }

    /**
     * Return a list of all seances conduite
     * */
    public static List<SeanceConduite> getAllSeancesConduite(){
        return SeanceConduiteReader.getAll();
    }


}
