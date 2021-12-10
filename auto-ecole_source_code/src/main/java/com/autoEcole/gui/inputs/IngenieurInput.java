package com.autoEcole.gui.inputs;

import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.services.IngenieurService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IngenieurInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Input the name from the user in the good format
     * Return the name in lowercase
     */
    public static String firstName(){
        String name = "";
        System.out.println("FIRST NAME: ");
        name = scanner.nextLine();
        while (!InputChecker.validName(name)){
            System.out.println("! NAME SHOULD CONTAIN ONLY ALPHABETS, WITH NO SPACES !");
            System.out.println("FIRST NAME: ");
            name = scanner.nextLine();
        }
        return name.toLowerCase();
    }

    /**
     * Input the name from the user in the good format
     * Return the name in lowercase
     */
    public static String lastName(){
        String name;
        System.out.println("LAST NAME: ");
        name = scanner.nextLine();
        while (!InputChecker.validName(name)){
            System.out.println("! NAME SHOULD CONTAIN ONLY ALPHABETS, WITH NO SPACES !");
            System.out.println("LAST NAME: ");
            name = scanner.nextLine();
        }
        return name.toLowerCase();

    }

    /**
     * Input the the cin from the user in the good format
     */
    public static String cin(){
        String cin = "";
        System.out.println("CIN: ");
        do {
            exceptionThrowed = false;
            try {
                cin = scanner.nextLine();
                if (!InputChecker.validIngenieurCin(cin)){
                    System.out.println("! PLEASE ENTER A UNIQUE AND VALID 8 DIGIT TUNISIAN CIN NUMBER !");
                    System.out.println("CIN: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID CIN !");
                System.out.println("CIN: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validIngenieurCin(cin));
        return cin;
    }

    /**
     * Ask the user if he wants to add Condidat now or not
     * Returns y or n
     */
    public static char askToAddNewEngineer(){
        char response = '0';
        System.out.println("ADD AN ENGINEER TO SESSION ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("ADD NEW ENGINEER ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("ADD NEW ENGINEER ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }

    /**
    * Input an engineer from user. Initialize availability to false and no working hours yet
    */
    public static Ingenieur engineer(){
        String firstName, lastName, cin;
        char category;
        int age, phoneNumber;

        firstName = IngenieurInput.firstName();
        lastName = IngenieurInput.lastName();
        cin = IngenieurInput.cin();

        // Initialize the engineer as not available and haven't worked yet. May be changed manually later
        Ingenieur ingenieur = new Ingenieur(cin,lastName,firstName,0,0);
        return ingenieur;
    }

    /**
     * Let the user Choose from an existing engineer by engineer's cin,
     * if available at the date chosen else return "0"
     * return the cin of the chosen engineer
     * */
    public static String chooseEngineerByCin(LocalDate date) {
        if (IngenieurService.getNumberOfEngineers() == 0 && IngenieurService.noEngineerAvailableOnDate(date)) { //There are no available engineers
            return "0";
        } else {
            String cin = "";
            System.out.println("CIN INGENIEUR: ");
            do {
                cin = scanner.nextLine();
                if (!InputChecker.validCinEngineerForUpdate(cin)) {
                    System.out.println("!CANNOT PROCEED WITH THAT CIN!");
                    System.out.println("CIN: ");
                } else {
                    if (!InputChecker.existedEngineerCin(cin)) {
                        System.out.println("NO ENGINEER WITH THAT CIN !");
                        System.out.println("CIN INGENIEUR: ");
                    } else if (!InputChecker.availableEngineerCin(cin, date)) {
                        System.out.println("THE ENGINEER WITH CIN: " + cin + " IS NOT AVAILABLE");
                        System.out.println("CIN INGENIEUR: ");
                    }
                }
            } while (!InputChecker.validCinEngineerForUpdate(cin) || !InputChecker.existedEngineerCin(cin) || !InputChecker.availableEngineerCin(cin, date));
            return cin;
        }
    }

    /**
     * Ask the user to add another existing engineer
     * */
    public static char askToAddAnotherExistingEngineer(){
        char response = '0';
        System.out.println("ADD ANOTHER ENGINEER ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("ADD ANOTHER ENGINEER ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("ADD ANOTHER ENGINEER ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }

    /**
     * Input from the user the choice of the main menu
     * 1:add engineer, 2:...
     * */
    public static String engineerMenuChoice(){
        String choice = "";
        while (!InputChecker.validIngenieurMenuChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input the cin of the engineer to update / delete
     * (should be in the database)
     * */
    public static String cinIngenieurForUpdate(){
        String cin = "";
        System.out.println("CIN: ");
        do {
            exceptionThrowed = false;
            try {
                cin = scanner.nextLine();
                if (!InputChecker.validCinEngineerForUpdate(cin)){
                    System.out.println("! NO ENGINEER WITH THAT CIN !");
                    System.out.println("CIN: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID CIN !");
                System.out.println("CIN: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validCinEngineerForUpdate(cin));
        return cin;
    }

}
