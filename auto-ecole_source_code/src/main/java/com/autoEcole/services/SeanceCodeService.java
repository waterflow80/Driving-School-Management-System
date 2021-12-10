package com.autoEcole.services;

import com.autoEcole.dao.Seances.SeanceCodeReader;
import com.autoEcole.dao.Seances.SeanceCodeWriter;
import com.autoEcole.dao.condidat.CondidatReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.SeanceCodeInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.SeanceCodeOutput;
import com.autoEcole.gui.outputs.SeanceOutput;

import java.util.List;

public class SeanceCodeService {

    /*public static Seance createSeanceWithNoCondidate(){

    }*/

    /**
    * Display the list of Existing Seances with the corresponding Candidate and Engineer
    */
    public static void displayAllSeancesWithAllDetails(){
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        for (Seance s: seanceCodes){
            SeanceOutput.displaySeanceWithAllDetails(s);
        }
    }

    /**
     * Display the list of Existing Seances with the corresponding Candidate and Engineer
     */
    public static void displayAllSeancesWithoutDetails(){
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        for (Seance s: seanceCodes){
            SeanceOutput.displaySeanceWithoutDetails(s);
        }
    }

    /**
     * Adding the seance code associated with new candidate to the json file (db)
     * */
    public static void AddSeanceCodeForCondidat(SeanceCode seance){
        SeanceCodeWriter.addSeanceCode(seance);
    }

    /**
     * Ask the user to enter e new seance and save it to the json file
     * */
    public static void ajouterSeanceCode(){
        SeanceCode seanceCode;
        SeanceCodeOutput.headerSeanceCode();
        SeanceCodeOutput.displayAllSeancesCodeAllDetails(SeanceCodeReader.getAll()); //Displaying all existing coding sessions
        seanceCode = SeanceCodeInput.seanceWithCondidats(); //Input session information from user
        if (seanceCode!=null){
            SeanceCodeWriter.addSeanceCode(seanceCode);
        }
    }


    /**
     * Delete code session from the database (json file)
     * */
    public static void supprimerSeanceCode(){
        char response;
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll(); //Get the current list of all code session
        if (seanceCodes.isEmpty()){
            System.out.println("THERE ARE NO SEANCES CODE AT THE MOMENT!");
        }else{
            SeanceCodeOutput.headerSupprimerSeanceCode();
            SeanceCodeOutput.displayAllSeancesCodeAllDetails(seanceCodes); //Displaying all seance code
            SeanceCodeOutput.askForSeanceCodeNumber();
            final Long number = SeanceCodeInput.seanceCodeNumber();
            SeanceCode seanceCode = SeanceCodeReader.getSeanceByNumber(number);
            response = SeanceCodeInput.askForDeleteConfirmation();
            if (response == 'y'){
                seanceCodes.removeIf(seanceCode1 -> seanceCode1.getNumber().equals(number));
                SeanceCodeWriter.addListSeancesCode(seanceCodes);
            }else{
                CondidatOutput.operationAborted(); //We borrowed this method from the condidat service
            }
        }

    }

    /**Display one session(all details)*/
    public static void afficherUneSeanceCode(){
        Long number;
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        if (!seanceCodes.isEmpty()){
            SeanceCodeOutput.headerAfficherUneSeanceCode();
            SeanceCodeOutput.displayAllSeancesCodeNumber(seanceCodes);
            SeanceCodeOutput.askForSeanceCodeNumber();
            number = SeanceCodeInput.seanceCodeNumber();
            SeanceCode seanceCode = SeanceCodeReader.getSeanceByNumber(number);
            if (seanceCode!=null){
                SeanceCodeOutput.displaySeanceCodeAllDetails(seanceCode);
            }
        }else {
            System.out.println("THERE ARE NO SEANCES CODE AT THE MOMENT !");
        }

    }

    /**
     * Displaying all Seances Code
     * */
    public static void afficherTousLesSeancesCode(){
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        if (!seanceCodes.isEmpty()){
            SeanceCodeOutput.displayAllSeancesCodeAllDetails(seanceCodes);
        }else {
            System.out.println("THERE ARE NO ACTUAL SEANCES CODE");
        }

    }

    /**
     * Return a list of all seances code
     * */
    public static List<SeanceCode> getAllSeancesCode(){
        return SeanceCodeReader.getAll();
    }



}
