package com.autoEcole.gui.inputs;

import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.IngenieurService;
import com.autoEcole.services.NumberGeneratorService;
import com.autoEcole.services.vehicules.MotoService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.autoEcole.gui.inputs.SeanceConduiteInput.inputExistingCinCondiat;
import static com.autoEcole.gui.inputs.SeanceConduiteInput.inputNumberCondidatsForSession;

public class SeanceCodeInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Input the choice for the seance code menu
     * 1: Ajouter une seance, 2: Supprimer une seance, 4: Afficher tous les seances
     * 3: Afficher une seance, 5: Menu principale
     * */
    public static String seanceCodeMenu(){
        String choice = "";
        while (!InputChecker.validSeanceCodeMenuChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input coding session information from user and asking for at least 2 candidates (their cin numbers)
     * */
    public static SeanceCode seanceWithCondidats(){
        SeanceCode seanceCode;
        char category = SeanceInput.category(); //( A / B / C )
        switch (category){
            case 'a': //A Category
                seanceCode = seanceCodeAWithCondidats();
                return seanceCode;
            case 'b':
                seanceCode = seanceCodeBWithCondidats();
                return seanceCode;
            case 'c':
                seanceCode = seanceCodeCWithCondidats();
                return seanceCode;
        }
        return null;
    }


    /**
     * Input code session category A's information from the user.
     * No Vehicles
     */
    public static SeanceCode seanceCodeAWithCondidats() {
        if (CondidatService.getNumberOfCondidats() < 2) { //at least two candiidates required to start a code session
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 2) TO MAKE THE SESSION, SORRY");
            return null;
        } else {
            String numImmatriculation = "";
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            //Adding an engineer to the session
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails();  //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an engineer from the existing list
            if (cinIngenieur.equals("0")) { //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            } else {
                //adding list of candidates
                String cin;
                int numberOfCondidats = 0; //should be no less than 2 to make a session
                numberOfCondidats = inputNumberCondidatsForSession();
                if (numberOfCondidats == 0)
                    return null; //We could not find sufficient number of candidates to create a session
                else {
                    CondidatService.displayAllCondidatsFewDetails();
                    for (int i = 0; i < numberOfCondidats; i++) { //adding the cin of candidates to the list
                        System.out.println("CONDIDAT N°" + i);
                        cin = inputExistingCinCondiat();
                        cinCondidats.add(cin);
                        CondidatService.incrementNbSeancesByCin(cin);
                    }
                    IngenieurService.incrementNbSeanceCodeIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                    IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur, date); //Adding this seance date to the list of seances of the concerned engineer
                    return new SeanceCode(number, date, cinCondidats, cinIngenieur, "a", 'c');
                }
            }
        }
    }

    /**
     * Input code session category B's information from the user.
     * No Vehicles
     */
    public static SeanceCode seanceCodeBWithCondidats() {
        if (CondidatService.getNumberOfCondidats() < 2) { //at least two candiidates required to start a code session
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 2) TO MAKE THE SESSION, SORRY");
            return null;
        } else {
            String numImmatriculation = "";
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails();  //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an engineer from the existing list
            if (cinIngenieur.equals("0")) { //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            } else {
                int numberOfCondidats = 0; //should be no less than 2 to make a session
                numberOfCondidats = inputNumberCondidatsForSession();
                if (numberOfCondidats == 0)
                    return null; //We could not find sufficient number of candidates to create a session
                else {
                    String cin;
                    CondidatService.displayAllCondidatsFewDetails();
                    for (int i = 0; i < numberOfCondidats; i++) { //adding the cin of condidates to the list
                        System.out.println("CONDIDAT N°" + i);
                        cin = inputExistingCinCondiat();
                        cinCondidats.add(cin);
                        CondidatService.incrementNbSeancesByCin(cin); //increment the number of the sessions that this candidate has
                    }
                    IngenieurService.incrementNbSeanceCodeIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                    IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur, date); //Adding this seance date to the list of seances of the concerned engineer
                    return new SeanceCode(number, date, cinCondidats, cinIngenieur, "b", 'c');
                }
            }
        }
    }

    /**
     * Input code session category B's information from the user.
     * No Vehicles
     */
    public static SeanceCode seanceCodeCWithCondidats(){
        if (CondidatService.getNumberOfCondidats() < 2){  //at least two candiidates required to start a code session
            System.out.println("THERE ARE NO SUFFICIENT NUMBER OF CANDIDATES (MIN: 2) TO MAKE THE SESSION, SORRY");
            return null;
        }else {
            String numImmatriculation = "";
            String cinIngenieur = "";
            SeanceCode seance;
            List<String> cinCondidats = new ArrayList<String>();
            LocalDate date = SeanceInput.seanceDate();
            Long number = NumberGeneratorService.getSeanceNumber();
            //ADDING ENGINEER
            System.out.println("CHOOSING ENGINEER");
            IngenieurOutput.engineersFewDetails();  //Displaying all existing engineers to choose from
            cinIngenieur = IngenieurInput.chooseEngineerByCin(date); //Choosing an available engineer from the existing list
            if (cinIngenieur.equals("0")) { //No available engineers at the moment
                System.out.println("THERE ARE NO AVAILABLE ENGINEERS AT THE MOMENT,\nWE CANNOT CREATE THE SESSION, SORRY!");
                return null;
            } else {
                int numberOfCondidats = 0; //should be no less than 2 to make a session
                numberOfCondidats = inputNumberCondidatsForSession();
                if (numberOfCondidats == 0)
                    return null; //We could not find sufficient number of candidates to create a session
                else{
                    String cin;
                    CondidatService.displayAllCondidatsFewDetails();
                    for (int i = 0; i < numberOfCondidats; i++) { //adding the cin of condidates to the list
                        System.out.println("CONDIDAT N°" + i);
                        cin = inputExistingCinCondiat();
                        cinCondidats.add(cin);
                        CondidatService.incrementNbSeancesByCin(cin); //increment the number of the sessions that this candidate has
                }
                IngenieurService.incrementNbSeanceCodeIngenieurByCin(cinIngenieur); //Incrementing the nb of hours of code session for this engineer
                IngenieurService.addDateSeanceForEngineerByCin(cinIngenieur, date); //Adding this seance date to the list of seances of the concerned engineer
                return new SeanceCode(number, date, cinCondidats, cinIngenieur, "c", 'c');
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
    public static Long seanceCodeNumber(){
        Long num = 0L;
        System.out.println("SEANCE NUMBER: ");
        do {
            exceptionThrowed = false;
            try {
                num = scanner.nextLong();
                if (!InputChecker.existedSeanceCodeNumber(num)){
                    System.out.println("! SEANCE NUMBER NOT FOUND !");
                    System.out.println("SEANCE NUMBER: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID SEANCE NUMBER !");
                System.out.println("SEANCE NUMBER: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.existedSeanceCodeNumber(num));
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

