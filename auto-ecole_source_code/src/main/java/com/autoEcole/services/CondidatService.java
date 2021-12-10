package com.autoEcole.services;

import com.autoEcole.dao.condidat.CondidatReader;
import com.autoEcole.dao.condidat.CondidatWriter;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.SeanceForCondidatInput;
import com.autoEcole.gui.inputs.SeanceInput;
import com.autoEcole.managemeent.Prix;
import com.autoEcole.services.prix.PrixService;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class CondidatService {


    public static void displayCondidatByCin(String cin){
        Condidat condidat = CondidatReader.getCondidatByCin(cin);
        CondidatOutput.condidatFewDetails(condidat);
    }

    /**
     * Display all candidates
     * With Few Or All Details (deoending on the user's choice)
     * */
    public static void afficherTousLesCondidats(){
        char response;
        CondidatOutput.headerAfficherTousLesCondidats();
        response = CondidatInput.askAllOrFewDetails();
        if (response == 'y'){ //with details
            displayAllCondidatsAllDetails();
        }else { // without details
            displayAllCondidatsFewDetails();
        }
    }

    /**
     * Display one condidat, selected by cin number
     * */
    public static void afficherUnCondidat(){
        String cin;
        char response;
        List<Condidat> condidats = CondidatReader.getAll();
        if (!condidats.isEmpty()){
            CondidatOutput.headerAfficherCondidat();
            CondidatOutput.displayAllCondidatsNameCin(condidats);
            CondidatOutput.askForCin();
            cin = CondidatInput.cinForUpdate();
            Condidat condidat = CondidatReader.getCondidatByCin(cin);
            if (condidat!=null){
                response = CondidatInput.askAllOrFewDetails();
                if (response == 'n'){ //display with few details
                    CondidatOutput.condidatFewDetails(condidat);
                }else {
                    CondidatOutput.condidatAllDetails(condidat);
                }
            }
        }else {
            System.out.println("THERE ARE NO CANDIDATES AT THE MOMENT !");
        }


    }

    /**
     * Add condidat to the list of all condidats
     * Save the new list to the JSON file (database)
     * */
    public static void ajouterCondidat(){
        /*char response;
        Seance seance;
        List<String> cinCondidats = new ArrayList<String>(); // will contain the cin of the new created candidate*/
        Condidat condidat;
        CondidatOutput.headerAjouterCondidat(); // DISPLAYS DEPARTMENT NAME
        CondidatOutput.condidatsFewDetails(CondidatReader.getAll()); //Display all existing candidates
        condidat = CondidatInput.condidatWithoutSeance();
        /*response =  SeanceInput.askToaddSeance(); // asking the user if he wants to associate a session to the candidate
        if (response == 'y'){ // Creating a new Seance for condidat
            condidat.incrementNbSeances();
            seance = SeanceForCondidatInput.seanceWithoutCondidat(condidat.getCategorie());
            cinCondidats.add(condidat.getCin()); // add the current condidat to the list of condidats associated with the seance
            assert seance != null;
            seance.setCinCondidats(cinCondidats);
            if (seance.getType() == 'd'){  // add the session as driving session
                SeanceConduiteService.addSeance((SeanceConduite)seance);
            }else{ // add the session as code sesison
                SeanceCodeService.AddSeanceCodeForCondidat((SeanceCode) seance);
            }
        }*/
        CondidatWriter.addCondidat(condidat); // adding the new condidat to the list of candidates
    }

    /**
     * Ask the user for the condidat to delete then deleting him
     * */
    public static void supprimerCondidat() {
        char response; //for delete confirmation

        List<Condidat> allCondidats = CondidatReader.getAll(); //get the list of all Condidats from the file
        if (allCondidats.isEmpty()){
            System.out.println("THERE ARE NO CONDIDATES AT THE MOMENT!");
        }else{
        CondidatOutput.headerSupprimerCondidat();
        CondidatOutput.condidatsFewDetails(allCondidats); //Displaying all candidates
        CondidatOutput.askForCin();
        final String cin = CondidatInput.cinForUpdate();;
        Condidat condidat = CondidatReader.getCondidatByCin(cin);
        CondidatOutput.condidatFewDetails(condidat);
        response = CondidatInput.askForDeleteConfirmation();
        if (response == 'y'){
            allCondidats.removeIf(condidat1 -> condidat1.getCin().equals(cin)); // Lambda expression to avoid concurrent modification exception
            CondidatWriter.addListCondidat(allCondidats);
            CondidatOutput.operationCompleted(); //Operation completed message
        }else {
            CondidatOutput.operationAborted();
        }
        }
    }

    /**
     * Directly delete condidat by his cin, returns the new list of condidats without the deleted one
     * Used for update
     * */
    public static List<Condidat> supprimerCondidatByCin(String cin){
        List<Condidat> condidats = CondidatReader.getAll(); //get the list of all condidats from the file
        condidats.removeIf(condidat1 -> condidat1.getCin().equals(cin)); // Lambda expression to avoid concurrent modification exception
        return condidats;
    }

    /**
     * Update caondiate attributes depending on the user's choice
     * */
    public static void updateCondidat(){
        char attribute;
        String cin = "";

        CondidatOutput.headerUpdateCondidat();
        List<Condidat> allCondidats = CondidatReader.getAll();
        if (allCondidats.isEmpty()){
            System.out.println("THERE ARE NO ACTUAL CANDIDATES AT THE MOMENT !");
        }else {
            CondidatOutput.condidatsFewDetails(allCondidats); //Displaying all candidates
            CondidatOutput.askForCin();
            cin = CondidatInput.cinForUpdate();
            Condidat condidat = CondidatReader.getCondidatByCin(cin); //The condidat to be updated
            CondidatOutput.condidatFewDetails(condidat);
            CondidatOutput.displayUpdateChoicesMenu();
            attribute = CondidatInput.askForAttributeToUpdate();
            switch (attribute) { //1: Montant Payee Code; 2: Montant Paye Conduite; 3: Exament Payee?
                case '1': //Montant Payee Code
                    Condidat newCondidat = updateCondidatMontantPayeeCode(condidat); //the condidat after update
                    if (newCondidat != null) {
                        List<Condidat> condidats = supprimerCondidatByCin(cin);
                        condidats.add(newCondidat);
                        CondidatWriter.addListCondidat(condidats);
                        CondidatOutput.operationCompleted();//complete
                        break;
                    } else
                        break;
                case '2': //Montant Paye Conduite
                    Condidat newCondidat1 = updateCondidatMontantPayeeConduite(condidat); //the condidat after update
                    if (newCondidat1 != null) {
                        List<Condidat> condidats = supprimerCondidatByCin(cin);
                        condidats.add(newCondidat1);
                        CondidatWriter.addListCondidat(condidats);
                        CondidatOutput.operationCompleted();//complete
                        break;
                    } else
                        break;

                case '4': //EXAMEN PAYEE
                    Condidat newCondidat2 = updateCondidatExamenPayee(condidat); //the condidat after update
                    if (newCondidat2 != null) {
                        List<Condidat> condidats = supprimerCondidatByCin(cin); //Delete the old condidat(before update)
                        condidats.add(newCondidat2); // add the new candidate(after update) to the list of candidates
                        CondidatWriter.addListCondidat(condidats); //add the list to the json file
                        CondidatOutput.operationCompleted();//operation completed message (confirmation)
                        break;
                    } else
                        break;
                case '3': //DATE EXAMEN
                    Condidat newCondidat3 = updateCondidatDateExamen(condidat); //the condidat after update
                    List<Condidat> condidats = supprimerCondidatByCin(cin); //Delete the old condidat(before update)
                    condidats.add(newCondidat3); // add the new candidate(after update) to the list of candidates
                    CondidatWriter.addListCondidat(condidats); //add the list to the json file
                    CondidatOutput.operationCompleted();//operation completed message (confirmation)
                    break;


            }
        }

    }

 /*  public static void addCondidat(Condidat condidat, List<Condidat> condidats){
        if (condidatHasSeance(condidat))
            condidat.incrementNbSeances();
        condidats.add(condidat);
    }*/

    public static Condidat getCondidatByCin(String cin) {
        Condidat condidat = CondidatReader.getCondidatByCin(cin);
        return condidat;
    }


    /**
     * Displaying all candidates with the minimum of details
     */
    public static void displayAllCondidatsFewDetails() {
        System.out.println("--DISPLAYING ALL CANDIDATES--");
        List<Condidat> condidats = CondidatReader.getAll();
        for (Condidat c: condidats){
            CondidatOutput.condidatFewDetails(c);
        }
    }

    /**
     * Displaying all candidates with all their details
     */
    public static void displayAllCondidatsAllDetails() {
        System.out.println("--DISPLAYING ALL CANDIDATES--");
        List<Condidat> condidats = CondidatReader.getAll();
        for (Condidat c: condidats){
            CondidatOutput.condidatAllDetails(c);
        }
    }


    /**
     * Update an Montant Payee code of candidate
     * Return Condidat after update
     * */
    public static Condidat updateCondidatMontantPayeeCode(Condidat condidat){
                char option1;
                CondidatOutput.displayMontantPayeeCode(condidat);
                CondidatOutput.displayMontantPayeeMenu();
                option1 = CondidatInput.getChoiceOfMontantPayee(); // 1: Mettre à nouveau le montant;2: Ajouter au montant existant
                switch (option1){
                    case '1': // mettre a nouveau le montant
                        assert condidat != null;
                        float newMontant = CondidatInput.getNewMontantCode(condidat);
                        if (CondidatInput.askForOptionConfirmation()){
                            condidat.setMontantPayeCode(newMontant);
                            CondidatOutput.operationCompleted();//complete
                            return condidat;
                        }else {
                            CondidatOutput.operationAborted();
                            return null;
                        }
                    case '2': //ajouter au montant existant
                        assert condidat != null;
                        float newMontant1 = CondidatInput.getMontantToAddCode(condidat);
                        if (CondidatInput.askForOptionConfirmation()) {
                            condidat.setMontantPayeCode(condidat.getMontantPayeCode() + newMontant1);
                            CondidatOutput.operationCompleted();//complete
                            return condidat;
                        }
                        else {
                                CondidatOutput.operationAborted();
                                return null;
                            }
                }
                return null;
    }

    /**
     * Update an Montant Payee code of candidate
     * Return Condidat after update
     * */
    public static Condidat updateCondidatMontantPayeeConduite(Condidat condidat){
        char option1;
        CondidatOutput.displayMontantPayeeConduite(condidat);
        CondidatOutput.displayMontantPayeeMenu();
        option1 = CondidatInput.getChoiceOfMontantPayee(); // 1: Mettre à nouveau le montant;2: Ajouter au montant existant
        switch (option1){
            case '1': // mettre a nouveau le montant
                assert condidat != null;
                float newMontant = CondidatInput.getNewMontantConduite(condidat);
                if (CondidatInput.askForOptionConfirmation()){
                    condidat.setMontantPayeConduite(newMontant);
                    CondidatOutput.operationCompleted();//complete
                    return condidat;
                }else {
                    CondidatOutput.operationAborted();
                    return null;
                }
            case '2': //ajouter au montant existant
                assert condidat != null;
                float newMontant1 = CondidatInput.getMontantToAddConduite(condidat);
                if (CondidatInput.askForOptionConfirmation()) {
                    condidat.setMontantPayeConduite(condidat.getMontantPayeConduite() + newMontant1);
                    CondidatOutput.operationCompleted();//complete
                    return condidat;
                }
                else {
                    CondidatOutput.operationAborted();
                    return null;
                }
        }
        return null;
    }

    /**
     * Update the candidate after updating the ExamenPayee attribute
     * */
    public static Condidat updateCondidatExamenPayee(Condidat condidat){
        boolean changeState = false;
        CondidatOutput.displayExamenPayeeState(condidat);
        changeState = CondidatInput.changeExamenPayeeState(condidat);
        if (changeState){
            if (condidat.isExamenPayee()){
                condidat.setExamenPayee(false);
                return condidat;
            }else {
                condidat.setExamenPayee(true);
                return condidat;
            }
        }
        return null;
    }

    /**
     * Return the candidate after updating the DateExamen attribute
     * */
    public static Condidat updateCondidatDateExamen(Condidat condidat){
        LocalDate newDate = LocalDate.of(1,1,1);
        CondidatOutput.displayDateExamenState(condidat);
        newDate = CondidatInput.ExamenDate();
        condidat.setDateExamen(newDate);
        return condidat;
    }

    /**
     * Check if the candidate has a session or not
     */
    public static boolean condidatHasSeance(Condidat condidat){
        String cinCondidat = condidat.getCin();
        List<SeanceCode> seancesCode = SeanceCodeService.getAllSeancesCode();
        // Testing if the cin of the candidate exists in the list of seancesCode
        for (SeanceCode s: seancesCode){
            for (String cin: s.getCinCondidats()){
                if (cinCondidat.equals(cin))
                    return true;
            }
        }

        List<SeanceConduite> seancesConduite = SeanceConduiteService.getAllSeancesConduite();
        // Testing if the cin of the candidate exists in the list of seancesCode
        for (SeanceConduite s: seancesConduite){
            for (String cin: s.getCinCondidats()){
                if (cinCondidat.equals(cin))
                    return true;
            }
        }
        return false;
    }

    /**
     * Search for candidate by cin and set the montant payee code to montant
     */
    public static void setMontantPayeeCodeByCin(float montant,String cin, List<Condidat> condidats){
        for (Condidat c: condidats){
            if (c.getCin().equals(cin))
                c.setMontantPayeCode(montant);
        }
    }

    /**
     * Search for candidate by cin and set the montant payee conduite to montant
     */
        public static void setMontantPayeeConduiteByCin(float montant,String cin, List<Condidat> condidats){
        for (Condidat c: condidats){
            if (c.getCin().equals(cin))
                c.setMontantPayeConduite(montant);
        }
    }

    /**
     * Check if the Candidate with the corresponding cin exists or not
     * */
    public static boolean condidatExistWithCin(String cin){
            List<Condidat> condidats = CondidatReader.getAll();
            for (Condidat c:condidats){
                if (c.getCin().equals(cin))
                    return true;
            }
            return false;
    }

    /**
     * Return the list of condiats that corresponds to the list of cin
     * */
    public static List<Condidat> getAllCondidatsByCin(List<String> cinCondidats){
        List<Condidat> allCondidats = CondidatReader.getAll();
        List<Condidat> newCondidats = new ArrayList<Condidat>();
        for (Condidat c: allCondidats){
            for (String s: cinCondidats){
                if (c.getCin().equals(s)){
                    newCondidats.add(c);
                    break;
                }
            }
        }
        return newCondidats;
    }

    /**
     * Return the current number of condidates
     * */
    public static int getNumberOfCondidats(){
        return CondidatReader.getAll().size();
    }

    /**
     * Increment the number of sessions the candidate has when assigning him a new one
     * */
    public static void incrementNbSeancesByCin(String cin){
        Condidat condidat = CondidatReader.getCondidatByCin(cin);
        if (condidat != null){
            condidat.incrementNbSeances();
            List<Condidat> condidats = supprimerCondidatByCin(cin); //deleting the old candidate
            condidats.add(condidat); //adding the new updated candidate
            CondidatWriter.addListCondidat(condidats);
        }
    }

    /**
     * Calculate the remaining amount of money for code sessions
     */
    public static double montantRestantCode(Condidat condidat, char categorie, int nbSeances){
        return PrixService.prixSeancesCode(categorie, nbSeances) -condidat.getMontantPayeCode();
    }

    /**
     * Calculate the remaining amount of money for driving sessions
     */
    public static double montantRestantConduite(Condidat condidat, char categorie, int nbSeances){
        return PrixService.prixSeancesConduite(categorie, nbSeances) - condidat.getMontantPayeConduite();
    }


    /**
     * Calculate the total remaining amount of money, Including the exam fee
     */
    public static double montantRestantTotal(Condidat condidat, char categorie, int nbSeances){
        if (condidat.isExamenPayee())
            return montantRestantConduite(condidat,categorie,nbSeances) + montantRestantCode(condidat,categorie,nbSeances);
        return PrixService.prixExamen + montantRestantConduite(condidat,categorie,nbSeances) + montantRestantCode(condidat,categorie,nbSeances);
    }

}
