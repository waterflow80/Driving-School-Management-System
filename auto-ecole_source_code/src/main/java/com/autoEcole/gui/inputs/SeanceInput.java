package com.autoEcole.gui.inputs;

import com.autoEcole.controllers.ingenieurControllers.IngenieurController;
import com.autoEcole.controllers.seanceControllers.SeanceCodeController;
import com.autoEcole.controllers.seanceControllers.SeanceConduiteController;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.services.IngenieurService;
import com.autoEcole.services.NumberGeneratorService;
import com.autoEcole.services.SeanceCodeService;
import com.autoEcole.services.SeanceConduiteService;

import java.time.LocalDate;
import java.util.*;

public class SeanceInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Input Seance from user
     * */
   /* public static Seance seance(){
        Seance seance;
        char type = SeanceInput.type(); // C: CODE, D: CONDUITE
        switch (type){
            case 'd': //Driving Session(Conduite)
                SeanceConduiteService.displayAllSeancesWithoutDetails();
                seance = seanceConduite();
                return seance;
            case 'c': //Code Session(Code)
                SeanceCodeService.displayAllSeancesWithoutDetails();
                seance = seanceCode();
                return seance;
        }
        return null;
    }

    *//**
     * Input Code session from user
     * *//*
    public static Seance seanceCode(){
        Seance seance;
        char category = SeanceInput.category(); //( A / B / C )
        switch (category){
            case 'a': //A Category
                seance = seanceCodeA();
                return seance;
            case 'b':
                seance = seanceCodeB();
                return seance;
            case 'c':
                seance = seanceCodeC();
                return seance;
        }
        return null;
    }

    *//**
     * Input Driving session from user
     * *//*
    public static Seance seanceConduite(){
        Seance seance;
        char category = SeanceInput.category(); //( A / B / C )
        switch (category){
            case 'a': //A Category
                seance = seanceConduiteA();
                return seance;
            case 'b':
                seance = seanceConduiteB();
                return seance;
            case 'c':
                seance = seanceConduiteC();
                return seance;
        }
        return null;
    }

    *//**
     * Input driving session category A's information from the user.
     * Vehicles are Motos
    *//*
    public static Seance seanceConduiteA(){
        List<Ingenieur> ingenieurs;
        Seance seance;
        Condidat condidat;
        List<String> cinCondidats = new ArrayList<String>();
        String cinIngenieur = "";
        Ingenieur ingenieur =null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule moto; // moto because the type of the driving session is A
        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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

        moto = VehiculeInput.chooseFromMotos();

        seance = new SeanceConduite(number,date,cinCondidats,cinIngenieur,"a",'d',moto.getNumImmatriculation());
        return seance;
    }

    *//**
     * Input driving session category B's information from the user.
     * Vehicles are Cars
     *//*
    public static Seance seanceConduiteB(){
        List<Ingenieur> ingenieurs;
        String cinIngenieur = "";
        Seance seance;
        Condidat condidat;
        List<String> cinCondidats = new ArrayList<String>();
        Ingenieur ingenieur=null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule voiture; // Voiture because the type of the driving session is A

        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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

        seance = new SeanceConduite(number,date,cinCondidats,cinIngenieur,"b",'d',voiture.getNumImmatriculation());
        return seance;
    }

    *//**
     * Input driving session category B's information from the user.
     * Vehicles are Camions
     *//*
    public static Seance seanceConduiteC(){
        List<Ingenieur> ingenieurs;
        String cinIngenieur = "";
        Seance seance;
        Condidat condidat;
        List<String> cinCondidats = new ArrayList<String>();
        Ingenieur ingenieur =null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule camion; // Voiture because the type of the driving session is A

        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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

        seance = new SeanceConduite(number,date,cinCondidats,cinIngenieur,"c",'d',camion.getNumImmatriculation());
        return seance;
    }


    *//**
     * Input code session category A's information from the user.
     * No Vehicles
     *//*
    public static Seance seanceCodeA(){
        String cinIngenieur = "";
        Seance seance;
        Condidat condidat;
        List<Ingenieur> ingenieurs;
        List<String> cinCondidats = new ArrayList<String>();
        Ingenieur ingenieur =null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule moto; // moto because the type of the driving session is A

        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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

        seance = new SeanceCode(number,date,cinCondidats,cinIngenieur,"a",'c');
        return seance;
    }

    *//**
     * Input code session category B's information from the user.
     * No Vehicles
     *//*
    public static Seance seanceCodeB(){
        List<Ingenieur> ingenieurs;
        String cinIngenieur = "";
        Seance seance;
        Condidat condidat;
        List<String> cinCondidats = new ArrayList<String>();
        Ingenieur ingenieur =null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule voiture; // Voiture because the type of the driving session is A

        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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

        seance = new SeanceCode(number,date,cinCondidats,cinIngenieur,"b",'c');
        return seance;
    }

    *//**
     * Input code session category B's information from the user.
     * No Vehicles
     *//*
    public static Seance seanceCodeC(){
        List<Ingenieur> ingenieurs;
        String cinIngenieur = "";
        Seance seance;
        Condidat condidat;
        List<String> cinCondidats = new ArrayList<String>();
        Ingenieur ingenieur = null;
        LocalDate date = SeanceInput.seanceDate();
        Long number = NumberGeneratorService.getSeanceNumber();
        Vehicule camion; // Voiture because the type of the driving session is A

        char ec;

        char ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        // Creating a new candidate
        while (ac == 'y'){
            condidat = CondidatInput.condidatWithoutSeance();
            cinCondidats.add(condidat.getCin());
            ac = CondidatInput.askToAddNewCondidat();// Ask the user if he wants to add a new candidate
        }
        // Adding from existing candidate
        ec = ac;
        do {
            condidat = CondidatInput.chooseCondidat();
            if (condidat != null)
                cinCondidats.add(condidat.getCin());
            ec = CondidatInput.askToAddAnotherExistingCondidat(); // Asking the user if he wants to add another candidate
        }while (ec == 'y');


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


        seance = new SeanceCode(number,date,cinCondidats,cinIngenieur,"c",'c');
        return seance;
    }
*/
    /**
     * Input the date of the session, should be valid and in maximum
     * 6 weeks
     * */
    public static LocalDate seanceDate(){
        System.out.println("SEANCE DATE:");
        int month, year, day, hour;
        year = SeanceInput.year();
        month = SeanceInput.month(year);
        day = SeanceInput.day(month,year);
//        hour = SeanceInput.hour(day,month,year);
        LocalDate date = LocalDate.of(year,month,day);
        return date;
    }

/*
    /**
     * Input the year of the driving period: sessions or exam
     * It should not be in the past neither after two nor more years
     */
    public static int year(){
        int year = 0;
        do { //input the year
            System.out.println("YEAR: ");
            exceptionThrowed = false;
            try {
                year = scanner.nextInt();
                if (!InputChecker.validYear(year)){
                    System.out.println("! PLEASE ENTER A VALID YEAR !");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID YEAR !");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validYear(year)) );
        return year;
    }

    /**
     * Input the month of the driving period: sessions or exam
     * It should not be in the past
     */
    public static int month(int year){
        int month = 0;
        do { //input the year
            System.out.println("MONTH: ");
            exceptionThrowed = false;
            try {
                month = scanner.nextInt();
                if (!InputChecker.validMonth(month, year)){
                    System.out.println("! PLEASE ENTER A VALID MONTH, DON'T DEPASS THE LIMIT OF 6 MONTHS !");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID MONTH !");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validMonth(month, year)) );
        return month;
    }

    /**
     * Input the day of the driving period: sessions or exam
     * It should not be in the past nor out of the month's range
     * example: February 28 days or 30 days
     */
    public static int day(int month, int year){
        int day = 0;
        do { //input the day
            System.out.println("DAY: ");
            exceptionThrowed = false;
            try {
                day = scanner.nextInt();
                if (!InputChecker.validDay(month, day,year)){
                    System.out.println("! CANNOT PROCEED WITH THAT DAY !");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID DAY !");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validDay(month, day,year)) );
        return day;
    }


    /**
     * Input the hour of the driving period: sessions or exam
     * It should not be in the past nor out of the hours's range
     */
    public static int hour(int day, int month, int year){
        int hour = 0;
        do { //input the hour
            System.out.println("HOUR: ");
            exceptionThrowed = false;
            try {
                hour = scanner.nextInt();
                if (!InputChecker.validHour(hour, day,month,year)){
                    System.out.println("! CANNOT PROCEED WITH THAT TIME !");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID HOUR !");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validHour(hour, day,month,year)) );
        return hour;
    }

/*
    *//**
     * Ask the user if he wants to add Seance now or not
     * Returns y or n
     *//*
    public static char askToaddSeance(){
        char response = '0';
        System.out.println("ADD SEANCE NOW ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("ADD SEANCE NOW ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("ADD SEANCE NOW ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }

*//*
    *//*
*//**
     * Input Seance number
     *//**//*

    public static int seanceNumber(){
        int number = 0;
        do { //input the hour
            System.out.println("NUMBER: ");
            exceptionThrowed = false;
            try {
                number = scanner.nextInt();
                if (!InputChecker.validSeanceNumber(number)){
                    System.out.println("! ALREADY EXISTED NUMBER !");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID NUMBER !");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validSeanceNumber(number)) );
        return number;
    }
*//*
*/
    /**
     * Input the category of the driving licence, must be A or B or C
     * Return a lowercase character
     */
    public static char category(){
        char category = 'n';
        System.out.println("CATEGORY (A/B/C): ");
        do {
            exceptionThrowed = false;
            try {
                category = scanner.next().charAt(0);
                if (!InputChecker.validCategory(category)){
                    System.out.println("! PLEASE ENTER A VALID DRIVING CATEGORY: A/B/C !");
                    System.out.println("CATEGORY(A/B/C): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID CHOICE !");
                System.out.println("CATEGORY(A/B/C): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validCategory(category)) );
        return Character.toLowerCase(category);
    }

/*
    *//**
     * Input the type of the session, must be D: Driving or C: Code
     * Return a lowercase character
     *//*
    public static char type(){
        char type = 'n';
        System.out.println("TYPE (D:conduite/C:code): ");
        do {
            exceptionThrowed = false;
            try {
                type = scanner.next().charAt(0);
                if (!InputChecker.validType(type)){
                    System.out.println("! PLEASE ENTER A VALID DRIVING CATEGORY: D/C !");
                    System.out.println("TYPE (D:conduite/C:code): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID CHOICE !");
                System.out.println("TYPE (D:conduite/C:code): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validType(type)) );
        return Character.toLowerCase(type);
    }
*/
    /**
     * Inpput the optino from the user
     * 1: seance code, 2: seance conduite, 3: menu principale
     * */
    public static String seanceMainMenuChoice(){
        String choice = "";
        while (!InputChecker.validSeanceMainMenuChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

}
