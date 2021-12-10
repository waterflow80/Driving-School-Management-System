package com.autoEcole.services;

import com.autoEcole.controllers.ingenieurControllers.IngenieurController;
import com.autoEcole.dao.Seances.SeanceCodeReader;
import com.autoEcole.dao.Seances.SeanceConduiteReader;
import com.autoEcole.dao.condidat.CondidatReader;
import com.autoEcole.dao.engineer.EngineerReader;
import com.autoEcole.dao.engineer.EngineerWriter;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.inputs.IngenieurInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.gui.outputs.SeanceOutput;
import com.autoEcole.gui.outputs.salaire.SalaireOutput;
import com.autoEcole.services.prix.PrixService;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IngenieurService {
    private static final int WIDTH = 30;

    /**
     * Add a new engineer to the list of all engineers
     * save the new list to the json file
     */
    public static void ajouterIngenieur() {
        Ingenieur ingenieur;
        IngenieurOutput.headerAjouterIngenieur(); //DISPLAY THE DEPARTMENT NAME
        IngenieurOutput.engineersFewDetails();
        ingenieur = IngenieurInput.engineer();
        EngineerWriter.addEngineer(ingenieur); //Adding the new engineer to the list of engineers
    }

    /**
     * Delete an engineer, by entering his cin
     */
    public static void supprimerIngenieur() {
        char response; //for delete confirmation
        List<Ingenieur> allIngenieurs = EngineerReader.getAll();
        if (allIngenieurs.isEmpty())
            System.out.println("YOU DON'Y HAVE ANY ENGINEER AT THE MOMENT !");
        else {
            IngenieurOutput.headerSupprimerIngenieur();
            IngenieurOutput.engineersFewDetails(); //displaying all existing engineers with few details
            IngenieurOutput.askForCinIngenieur();
            final String cin = IngenieurInput.cinIngenieurForUpdate(); //input an existing cin of engineer
            Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin); //Retrieve the concerned engineer from the database
            IngenieurOutput.engineerFewDetails(ingenieur); //Displaying the engineer to be deleted
            response = CondidatInput.askForDeleteConfirmation(); //Function borrowed from the candidate department(asking for delete confirmation)
            if (response == 'y') {
                allIngenieurs.removeIf(ingenieur1 -> ingenieur1.getCin().equals(cin)); // Lambda expression to avoid concurrent modification exception
                EngineerWriter.addListEngineers(allIngenieurs);
                CondidatOutput.operationCompleted(); //operation completed message (borrowed function)
            } else {
                CondidatOutput.operationAborted(); //operation aborted message (borrowed function)
            }

        }
    }

    /**
     * Display the engineer selected by the cin number, with all details
     */
    public static void afficherUnIngenieur() {
        String cin;
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        if (!ingenieurs.isEmpty()) {
            IngenieurOutput.headerAfficherIngenieur();
            IngenieurOutput.engineersFewDetails(); //display all engineers with few detils
            IngenieurOutput.askForCinIngenieur(); //asking for cin engineer to display
            cin = IngenieurInput.cinIngenieurForUpdate();
            Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin);
            if (ingenieur != null) {
                IngenieurOutput.engineerAllDetails(ingenieur);
            } else {
                System.out.println("CANNOT FIND ENGINEER !");
            }
        }else {
            System.out.println("THERE ARE NO ENGINEERS AT THE MOMENT !");
        }
    }

    /**
     * Display all engineers with all details
     * */
    public static void afficherTousLesIngenieurs(){
        IngenieurOutput.engineersAllDetails();
    }

    /**
     * Update engineer section
     * */
    public static void updateIngenieur(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("?");
        System.out.println(" \nTHIS FEATURE IS NOT AVAILABLE \n" +
                "RIGHT NOW BECAUSE " +
                "WE CAN'T \nFIND FIELDS THAT CAN BE UPDATED !\n " +
                "BUT THIS WILL BE AVAILABLE SOON ");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("?");
        System.out.println();
    }

    /**
     * Display all engineers with all their details
     * */
    public static void displayAllEngineersAllDetails(){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        IngenieurOutput.engineersAllDetails();
    }


    /**
     * Return the engineer by cin number
     * */
    public static Ingenieur getEngineerByCin(String cin){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        for (Ingenieur i: ingenieurs){
            if (i.getCin().equals(cin))
                return i;
        }
        return null;
    }

    /**
     * Saving a new engineer to the json file (database)
     * */
    public static void addIngenieur(Ingenieur ingenieur){
        EngineerWriter.addEngineer(ingenieur);
    }

    /**
     * Display an engineer by his cin number
     * */
    public static void displayEngineerByCin(String cin){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin);
        IngenieurOutput.engineerAllDetails(ingenieur);
    }

    /**
     * Return the list of all engineers
     * */
    public static List<Ingenieur> getAllEngineers(){
        return EngineerReader.getAll();
    }

    /**
     * Retrun the current number of engineers
     * */
    public static int getNumberOfEngineers(){
        return getAllEngineers().size();
    }

    /**
     * Incrementing the number of hours of code sessions of the engineer
     * (in case of he has been assigned to a code session
     * */
    public static void incrementNbSeanceCodeIngenieurByCin(String cin){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin); //The engineer to be updated
        if (ingenieur != null) {
            ingenieur.setNbHeuresCode(ingenieur.getNbHeuresCode() + 1); //incrementing the nb of hours of code session
            List<Ingenieur> newListEngineers = supprimerIngenieurByCin(cin);
            newListEngineers.add(ingenieur);//Adding the new updated engineer to the list
            EngineerWriter.addListEngineers(newListEngineers); //Writing the new list of engineers to the file
        }
    }
    /**
     * Incrementing the number of hours of driving sessions of the engineer
     * (in case of he has been assigned to a driving session
     * */
    public static void incrementNbSeanceConduiteIngenieurByCin(String cin){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin); //The engineer to be updated
        if (ingenieur != null) {
            ingenieur.setNbHeuresConduite(ingenieur.getNbHeuresConduite() + 1); //incrementing the nb of hours of driving session
            List<Ingenieur> newListEngineers = supprimerIngenieurByCin(cin);
            newListEngineers.add(ingenieur);//Adding the new updated engineer to the list
            EngineerWriter.addListEngineers(newListEngineers); //Writing the new list of engineers to the file
        }else
            System.out.println("Engineer with cin " + cin + " Not found !");
    }


    /**
     * Directly delete engineer by his cin, returns the new list of engineers without the deleted one
     * Used for update
     * */
    public static List<Ingenieur> supprimerIngenieurByCin(String cin){
        List<Ingenieur> ingenieurs = EngineerReader.getAll(); //get the list of all engineers from the file
            if (!ingenieurs.isEmpty()){
            ingenieurs.removeIf(ingenieur1 -> ingenieur1.getCin().equals(cin)); // Lambda expression to avoid concurrent modification exception
            return ingenieurs;
        }
        return ingenieurs; //empty list
    }

    /**
     * Adding a seanceDate {"day", "month", "year"} to the list of seancesDates of the engineer
     * */
    public static void addDateSeanceForEngineerByCin(String cin, LocalDate date){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin); //The concerned engineer
        if (ingenieur !=null) {
            ingenieur.addSeanceDate(date);
            List<Ingenieur> ingenieurs = supprimerIngenieurByCin(cin);
            ingenieurs.add(ingenieur);
            EngineerWriter.addListEngineers(ingenieurs);
            CondidatOutput.operationCompleted();
        }else
            System.out.println("Engineer with cin: " + cin + " Not Found");
    }

    /**
     * Check if there are engineers available on that date or not
     * */
    public static boolean noEngineerAvailableOnDate(LocalDate date){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        if (!ingenieurs.isEmpty()) {
            int counter = 0;
            for (Ingenieur i : ingenieurs) {
                for (LocalDate ld: i.getSeancesDates()){
                    if (!(ld.compareTo(date) == 0))
                        counter++;
                if (counter == i.getSeancesDates().size()) //the number of no matching is equal to the number of dates of the engineer
                    return false; //there is at least one engineer available
                }
            }
        }
        return true;
    }

    /**
     * Check if there's a candidate with the corresponding cin number
     * */
    public static boolean IngenieurExistWithCin(String cin){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        for (Ingenieur i: ingenieurs){
            if (i.getCin().equals(cin))
                return true;
        }
        return false;
    }

    /**
     * Check if there's an engineer in the database with that cin
     * */
    public static boolean ingenieurExistsWithCin(String cin){
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        for (Ingenieur i: ingenieurs){
            if (i.getCin().equals(cin))
                return true;
        }
        return false;
    }

    /**
     * Return all the code sessions that are associated with the specified engineer
     * */
    public static List<SeanceCode> getSeancesCodeAssociatedWithEngineerCin(String cin){
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        if (!seanceCodes.isEmpty()) {
            List<SeanceCode> seanceCodes1 = new ArrayList<SeanceCode>(); //the matched list
            for (SeanceCode s : seanceCodes) {
                if (s.getCinIngenieur().equals(cin))
                    seanceCodes1.add(s);
            }
            return seanceCodes1;
        }
        return null;
    }

    /**
     * Return all the driving sessions that are associated with the specified engineer
     * */
    public static List<SeanceConduite> getSeancesConduiteAssociatedWithEngineerCin(String cin){
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        if (!seanceConduites.isEmpty()) {
            List<SeanceConduite> seanceConduites1 = new ArrayList<SeanceConduite>(); //the matched list
            for (SeanceConduite s : seanceConduites) {
                if (s.getCinIngenieur().equals(cin))
                    seanceConduites1.add(s);
            }
            return seanceConduites1;
        }
        return null;
    }

    /**
     * Calculate the salary of an engineer (this functions needs more update because it's not accurate)
     * */
    public static float calculateSalarayEngineer(Ingenieur ingenieur, List<SeanceCode> seanceCodes, List<SeanceConduite> seanceConduites){
        float salary = 0;
        if (seanceCodes != null) {
            for (SeanceCode s : seanceCodes) {
                salary += PrixService.prixSeancesCode(s.getCategorie().charAt(0), (int) ingenieur.getNbHeuresCode());
            }
        }
        if (seanceConduites != null) {
            for (SeanceConduite s : seanceConduites) {
                salary += PrixService.prixSeancesConduite(s.getCategorie().charAt(0), (int) ingenieur.getNbHeuresConduite());
            }
        }
        return salary;

    }

    /**
     * Display the salary of an engineer by cin number
     * */
    public static void displaySalaireByCin(String cin){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin);
        List<SeanceCode> seancesCodeAssociatedWithEngineer = getSeancesCodeAssociatedWithEngineerCin(cin);
        List<SeanceConduite> seancesConduiteAssociatedWithEngineer = getSeancesConduiteAssociatedWithEngineerCin(cin);
        float salaire = calculateSalarayEngineer(ingenieur, seancesCodeAssociatedWithEngineer,seancesConduiteAssociatedWithEngineer);
        SalaireOutput.headerDisplayingSalary();
        SalaireOutput.displaySalaireIngenieur(ingenieur, salaire);
    }
}
