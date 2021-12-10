package com.autoEcole.gui.inputs;

import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.gui.inputs.flotte.CamionInput;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.inputs.flotte.VoitureInput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.IngenieurService;
import com.autoEcole.services.NumberGeneratorService;
import com.autoEcole.services.vehicules.CamionService;
import com.autoEcole.services.vehicules.MotoService;
import com.autoEcole.services.vehicules.VoitureService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SeanceConduiteInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;

    /**
     * Input the choice for the seance conduite menu
     * 1: Ajouter une seance, 2: Supprimer une seance, 4: Afficher tous les seances
     * 3: Afficher une seance, 5: Menu Principale
     * */
    public static String seanceConduiteMenu(){
        String choice = "";
        while (!InputChecker.validSeanceCodeMenuChoice(choice)){ //the same test as seance code
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input coding session information from user and asking for at least 2 candidates (their cin numbers)
     * */
    public static SeanceConduite seanceWithCondidats(){
        SeanceConduite seanceConduite;
        char category = SeanceInput.category(); //( A / B / C )
        switch (category){
            case 'a': //A Category
                seanceConduite = seanceConduiteAWithCondidats();
                return seanceConduite;
            case 'b':
                seanceConduite = seanceConduiteBWithCondidats();
                return seanceConduite;
            case 'c':
                seanceConduite = seanceConduiteCWithCondidats();
                return seanceConduite;
        }
        return null;
    }


    /**
     * Input driving session category A's (moto) information from the user.
     * No Vehicles
     */
    public static SeanceConduite seanceConduiteAWithCondidats(){
        if (CondidatService.getNumberOfCondidats() < 1){ //there are no candiadtes at the moment
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 1) TO MAKE THE SESSION, SORRY");
            return null;
        }else {
            Long numImmatriculation = 0L;
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails(); //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an engineer from the existing list
            if (cinIngenieur.equals("0")){ //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            }else{
                if (MotoService.getAllMotos().isEmpty()){ //No motos availabe
                    System.out.println("THERE ARE NO ACTUAL MOTOS IN THE GARAGE, THE SESSION WON'T BE CREATED");
                    return null;
                }else {
                    String cin;
                    CondidatService.displayAllCondidatsFewDetails();
                    System.out.println("CONDIDAT CIN°");
                    cin = inputExistingCinCondiat();
                    cinCondidats.add(cin);
                    CondidatService.incrementNbSeancesByCin(cin); //incrementing the number of sessions that the candidate has
                    MotoService.displayAllMotosFewDetails();
                    numImmatriculation = MotoInput.chooseNumImmatriculationMoto();
                    MotoService.changeDisponibiliteMotoByNumImmatriculation(numImmatriculation); //Changing the state of disponible of the moto to false
                    IngenieurService.incrementNbSeanceConduiteIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                    IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur,date); //Adding this seance date to the list of seances of the concerned engineer
                    return new SeanceConduite(numImmatriculation,date,cinCondidats,cinIngenieur,"a",'d',numImmatriculation);
                }
            }
            }
        }



    /**
     * Input code session category B's (voiture) information from the user.
     * No Vehicles
     */
    public static SeanceConduite seanceConduiteBWithCondidats() {
        if (CondidatService.getNumberOfCondidats() < 1) { //there are no candiadtes at the moment
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 1) TO MAKE THE SESSION, SORRY");
            return null;
        } else {
            Long numImmatriculation = 0L;
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails(); //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an engineer from the existing list
            if (cinIngenieur.equals("0")) { //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            } else {
                if (VoitureService.getAllVoitures().isEmpty()) { //No motos availabe
                    System.out.println("THERE ARE NO ACTUAL VOITURES IN THE GARAGE, THE SESSION WON'T BE CREATED");
                    return null;
                } else {
                        String cin;
                        CondidatService.displayAllCondidatsFewDetails();
                        System.out.println("CONDIDAT CIN" );
                        cin = inputExistingCinCondiat();
                        cinCondidats.add(cin);
                        CondidatService.incrementNbSeancesByCin(cin); //incrementing the number of sessions that the candidate has
                        VoitureService.displayAllVoituresFewetails();
                        numImmatriculation = VoitureInput.chooseNumImmatriculationVoiture();
                        VoitureService.changeDisponibiliteVoitureByNumImmatriculation(numImmatriculation); //Changing the state of disponible of the car to false
                        IngenieurService.incrementNbSeanceConduiteIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                        IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur, date); //Adding this seance date to the list of seances of the concerned engineer
                        return new SeanceConduite(numImmatriculation, date, cinCondidats, cinIngenieur, "b", 'd', numImmatriculation);
                    }
                }
            }
        }

    /**
     * Input code session category C's (camion) information from the user.
     * No Vehicles
     */
    public static SeanceConduite seanceConduiteCWithCondidats(){
        if (CondidatService.getNumberOfCondidats() < 1){ //there are no candiadtes at the moment
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 1) TO MAKE THE SESSION, SORRY");
            return null;
        }else {
            Long numImmatriculation = 0L;
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails(); //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an engineer from the existing list
            if (cinIngenieur.equals("0")){ //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            }else{
                if (CamionService.getAllCamions().isEmpty()){ //No motos availabe
                    System.out.println("THERE ARE NO ACTUAL CAMIONS IN THE GARAGE, THE SESSION WON'T BE CREATED");
                    return null;
                }else {
                    String cin;
                    CondidatService.displayAllCondidatsFewDetails();
                    System.out.println("CONDIDAT CIN°");
                    cin = inputExistingCinCondiat();
                    cinCondidats.add(cin);
                    CondidatService.incrementNbSeancesByCin(cin); //incrementing the number of sessions that the candidate has
                    CamionService.displayAllCamionsFewDetails();
                    numImmatriculation = CamionInput.chooseNumImmatriculationCamion();
                    CamionService.changeDisponibiliteCamionByNumImmatriculation(numImmatriculation); //Changing the state of disponible of the camion to false
                    IngenieurService.incrementNbSeanceCodeIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                    IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur,date); //Adding this seance date to the list of seances of the concerned engineer
                    return new SeanceConduite(numImmatriculation,date,cinCondidats,cinIngenieur,"c",'d',numImmatriculation);
                }
            }
            }
        }


    /**
     * Input the number of candidates to add to the session, Minimum 2
     * */
    public static int inputNumberCondidatsForSession(){
        int number = 0;
        System.out.println("NUMBER OF CANDIDATES: ");
        do {
            exceptionThrowed = false;
            try {
                number = scanner.nextInt();
                //System.out.println("Number of condidats : " + CondidatService.getNumberOfCondidats());
                if (!InputChecker.validNumberOfCandidates(number)){
                    System.out.println("! NUMBER SHOULD BE NO LESS THAN 2 !");
                    System.out.println("NUMBER OF CANDIDATES: ");
                    scanner.nextLine();
                    }
                else if (!InputChecker.numberWithinTheRangeOfExistingCandidates(number)) {
                        System.out.println("THE MAXIMUM NUMBER OF CANDIDATES IS: " + CondidatService.getNumberOfCondidats());
                        System.out.println("NUMBER OF CANDIDATES: ");
                        scanner.nextLine();
                    }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID NUMBER !");
                System.out.println("NUMBER OF CANDIDATES: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !InputChecker.validNumberOfCandidates(number) || !InputChecker.numberWithinTheRangeOfExistingCandidates(number));
        return number;
    }

    /**
     * Input a cin number of an existing candidate
     * */
    public static String inputExistingCinCondiat(){
        String cin = "";
        System.out.println("CIN CONDIDAT: ");
        do {
            exceptionThrowed = false;
            try {
                cin = scanner.nextLine();
                if (!InputChecker.existedCondidatCinNumber(cin)){
                    System.out.println("! CIN NUMBER NOT FOUND !");
                    System.out.println("CIN: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID CIN !");
                System.out.println("CIN CONDIDAT: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedCondidatCinNumber(cin));
        return cin;
    }

    /**Input the number of an existing code session from the user
     * */
    public static Long seanceConduiteNumber(){
        Long num = 0L;
        System.out.println("SEANCE NUMBER: ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.existedSeanceConduiteNumber(num)){
                    System.out.println("! SEANCE NUMBER NOT FOUND !");
                    System.out.println("SEANCE NUMBER: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID SEANCE NUMBER !");
                System.out.println("SEANCE NUMBER: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedSeanceConduiteNumber(num));
        return num;
    }

    /**
     * Asking for confirmation from the user (for deletion)
     * returns y or n
     * */
    public static char askForDeleteConfirmation(){
        char response = '0';
        System.out.println("CONFIRM DELETION ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("CONFIRM DELETION ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("CONFIRM DELETION ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }
}
