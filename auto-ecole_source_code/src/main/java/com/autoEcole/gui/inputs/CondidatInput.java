package com.autoEcole.gui.inputs;

import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.managemeent.Prix;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.prix.PrixService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CondidatInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;


    /**
     * Input user's choice from the 'Condidat Menu'
     */
    public static String condidatMenu(){

        String choice = "";
        while (!InputChecker.validCondidateChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    /**
     * Input user's choice from the 'Ajouter Condidat Menu'
     */
    public static String ajouterCondidatMenu(){
        String choice = "";
        while (!InputChecker.validAjouterCondidatMenuChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

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
    public static String cinForUpdate(){
        String cin = "";
        System.out.println("CIN: ");
        do {
            exceptionThrowed = false;
            try {
                cin = scanner.nextLine();
                if (!InputChecker.validCinCondidatForUpdate(cin)){
                    System.out.println("! CIN DOES NOT EXIST !");
                    System.out.println("CIN: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID CIN !");
                System.out.println("CIN: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validCinCondidatForUpdate(cin));
        return cin;
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
                if (!InputChecker.validCin(cin)){
                    System.out.println("! PLEASE ENTER A VALID 8 DIGIT TUNISIAN CIN NUMBER !");
                    System.out.println("CIN: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID CIN !");
                System.out.println("CIN: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validCin(cin));
        return cin;
    }

    /**
     * Input the the age from the user in the good format
     */
    public static int age(){
        int age = 0;
        System.out.println("AGE: ");
        do {
            exceptionThrowed = false;
            try {
                age = scanner.nextInt();
                if (!InputChecker.validAge(age)){
                    System.out.println("! AGE MUST BE BETWEEN 18 AND 110 :) !");
                    System.out.println("AGE: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID AGE :) !");
                System.out.println("AGE: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !InputChecker.validAge(age));
        return age;
    }

    /**
     * Input the phone number from the user,
     * Respecting the Tunisian phone numbers format
     * Returns an 8-digit number
     */
    public static int phoneNumber(){
        int phoneNumber = 0;
        System.out.println("PHONE NUMBER(+216): ");
        do {
            exceptionThrowed = false;
            try {
                phoneNumber = scanner.nextInt();
                if (!InputChecker.validTunisiaPhoneNumber(phoneNumber)){
                    System.out.println("! PLEASE ENTER A VALID 8 DIGIT TUNISIAN PHONE NUMBER :) !");
                    System.out.println("PHONE NUMBER(+216): ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID PHONE NUMBER :) !");
                System.out.println("PHONE NUMBER(+216): ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validTunisiaPhoneNumber(phoneNumber)) );
        scanner.nextLine();
        return phoneNumber;
    }

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

    /**
     * Input the type of the driving licence, must be D or C
     * Return a lowercase character
     */
    public static char type(){
        char type = 'n';
        System.out.println("TYPE (D: Driving/ C: Code): ");
        do {
            exceptionThrowed = false;
            try {
                type = scanner.next().charAt(0);
                if (!InputChecker.validType(type)){
                    System.out.println("! PLEASE ENTER A VALID COURSE TYPE: D/C !");
                    System.out.println("TYPE (D: Driving/ C: Code): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID CHOICE !");
                System.out.println("TYPE (D: Driving/ C: Code): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validType(type)) );
        return Character.toLowerCase(type);
    }

    /**
     * Input a candidate without associating him a session
     */
    public static Condidat condidatWithoutSeance(){
        String firstName, lastName, cin;
        char category;
        int age, phoneNumber;

        firstName = CondidatInput.firstName();
        lastName = CondidatInput.lastName();
        cin = CondidatInput.cin();
        age = CondidatInput.age();
        phoneNumber = CondidatInput.phoneNumber();
        category = CondidatInput.category();
    /*    montantPayeeCode = CondidatInput.montantPayeeCode(category);
        montantPayeeConduite = CondidatInput.montantPayeeConduite(category);
        examenPayee = CondidatInput.examenPayee();*/

        Condidat condidat= new Condidat(cin, lastName,firstName,age,phoneNumber,category);
        return condidat;
    }

    /**
     * Ask the user if he wants to add Condidat now or not
     * Returns y or n
     */
    public static char askToAddNewCondidat(){
        char response = '0';
        System.out.println("ADD NEW CONDIDAT ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("ADD NEW CONDIDAT ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("ADD NEW CONDIDAT ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }

    /**
     * Choose candidate from the list of candidates by cin number
     * */
    public static Condidat chooseCondidat(){
        Condidat condidat;
        CondidatService.afficherTousLesCondidats();
        System.out.println("Find Condidat by CIN:");
        String cin =  CondidatInput.cin();
        CondidatService.displayCondidatByCin(cin);
        condidat = CondidatService.getCondidatByCin(cin);
        return condidat; // may return null
    }

    /**
     * Ask the user if wants to add another candidate to the session
     * */
    public static char askToAddAnotherExistingCondidat(){
        char response = '0';
        System.out.println("ADD ANOTHER CONDIDAT ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("ADD ANOTHER CONDIDAT ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("ADD ANOTHER CONDIDAT ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
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

    public static boolean askForOptionConfirmation(){
        char response = '0';
        System.out.println("CONFIRM OPERATION ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("CONFIRM OPERATION ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("CONFIRM DELETION ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        if (response == 'y')
            return true;
        return false;
    }

    /**
     * Asking if he wants to display candidate with all details or with fewer
     * */
    public static char askAllOrFewDetails(){
        char response = '0';
        System.out.println("DISPLAY WITH ALL DETAILS ?(Y/N): ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("DISPLAY WITH ALL DETAILS ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("CONFIRM DELETION ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        return Character.toLowerCase(response);
    }

    /**
     * Ask the user to enter which attribute to update
     * 1: montant payee code, 2: montant payee conduite, 3: examen payee ?)
     * */
    public static char askForAttributeToUpdate() { // only for
        char response = '0';
        System.out.println("CHOOSE OPTION: ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validUpdateAttributeChoiceMenu(response)) {
                    System.out.println("! PLEASE ENTER A VALID OPTION !");
                    System.out.println("CHOOSE OPTION : ");
                }
            } catch (InputMismatchException e) {
                System.out.println("! PLEASE ENTER A VALID OPTION Y OR N !");
                System.out.println("CHOOSE OPTION: ");
                exceptionThrowed = true;
            }
        } while ((exceptionThrowed) || !(InputChecker.validUpdateAttributeChoiceMenu(response)));
        return Character.toLowerCase(response);
    }

    /**
     * Input which operation to make over the attribute
     * */
    public static char getChoiceOfMontantPayee(){
        char response = '0';
        System.out.println("CHOOSE OPTION: ");
        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validUpdateAttributeChoice(response)) {
                    System.out.println("! PLEASE ENTER A VALID OPTION !");
                    System.out.println("CHOOSE OPTION : ");
                }
            } catch (InputMismatchException e) {
                System.out.println("! PLEASE ENTER A VALID OPTION Y OR N !");
                System.out.println("CHOOSE OPTION: ");
                exceptionThrowed = true;
            }
        } while ((exceptionThrowed) || !(InputChecker.validUpdateAttributeChoice(response)));
        return Character.toLowerCase(response);
    }

    /**
     * Input the new amount of money paid for the code session
     * */
    public static float getNewMontantCode(Condidat condidat){
        char category = condidat.getCategorie();
        float newMontant = 0f;
        System.out.println("NOUVEAU MONTANT: ");
        do {
            exceptionThrowed = false;
            try {
                newMontant = scanner.nextFloat();
                if (!InputChecker.validNewMontantCode(category,newMontant, condidat.getNbSeances())){
                    System.out.println("! PRICE SHOULD BE BETWEEN 0 AND " +
                            PrixService.prixSeancesCode('a',condidat.getNbSeances()) + " (Prix total des seances code categorie A)");
                    System.out.println("NOUVEAU MONTANT: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID OPTION :) !");
                System.out.println("NOUVEAU MONTANT: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validNewMontantCode(category,newMontant, condidat.getNbSeances())) );
        scanner.nextLine();
        return newMontant;
    }

    /**
     * Input the new amount of money paid for the code session
     * */
    public static float getNewMontantConduite(Condidat condidat){
        char category = condidat.getCategorie();
        float newMontant = 0f;
        System.out.println("NOUVEAU MONTANT: ");
        do {
            exceptionThrowed = false;
            try {
                newMontant = scanner.nextFloat();
                if (!InputChecker.validNewMontantConduite(category,newMontant, condidat.getNbSeances())){
                    System.out.println("! PRICE SHOULD BE BETWEEN 0 AND " +
                            PrixService.prixSeancesConduite('a',condidat.getNbSeances()) + " (Prix total des seances code categorie A)");
                    System.out.println("NOUVEAU MONTANT: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID OPTION :) !");
                System.out.println("NOUVEAU MONTANT: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validNewMontantConduite(category,newMontant, condidat.getNbSeances())) );
        scanner.nextLine();
        return newMontant;
    }

    /**
     * Input the montant to add to the Montant payee code
     * */
    public static float getMontantToAddCode(Condidat condidat){
        float montantToAdd = 0f;
        System.out.println("MONTANT TO ADD: ");
        do {
            exceptionThrowed = false;
            try {
                montantToAdd = scanner.nextFloat();
                if (!InputChecker.validMontantToAddCode(montantToAdd, condidat)){
                    System.out.println("MONTANT SHOULD BE BETWEE 0 AND "+ CondidatService.montantRestantCode(condidat, condidat.getCategorie(),condidat.getNbSeances()) + " (montant restant)");
                    System.out.println("MONTANT TO ADD: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID OPTION :) !");
                System.out.println("MONTANT TO ADD: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validMontantToAddCode(montantToAdd, condidat) ));
        scanner.nextLine();
        return montantToAdd;
    }

    /**
     * Input the montant to add to the Montant payee conduite
     * */
    public static float getMontantToAddConduite(Condidat condidat){
        float montantToAdd = 0f;
        System.out.println("MONTANT TO ADD: ");
        do {
            exceptionThrowed = false;
            try {
                montantToAdd = scanner.nextFloat();
                if (!InputChecker.validMontantToAddConduite(montantToAdd, condidat)){
                    System.out.println("MONTANT SHOULD BE BETWEE 0 AND "+ CondidatService.montantRestantCode(condidat, condidat.getCategorie(), condidat.getNbSeances()) + " (montant restant)");
                    System.out.println("MONTANT TO ADD: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID OPTION :) !");
                System.out.println("MONTANT TO ADD: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validMontantToAddConduite(montantToAdd, condidat) ));
        scanner.nextLine();
        return montantToAdd;
    }

    /**
     * Ask the user to set the sate of ExamenPayee to False(if it's True) or
     * to True (if it's False)
     * */
    public static boolean changeExamenPayeeState(Condidat condidat){
        char response = '0';
        if (condidat.isExamenPayee()){
            System.out.println("SET TO FALSE ?(Y/N): ");
        }else {
            System.out.println("SET TO TRUE ?(Y/N): ");
        }

        do {
            exceptionThrowed = false;
            try {
                response = scanner.next().charAt(0);
                if (!InputChecker.validYesOrNoAnswer(response)){
                    System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                    System.out.println("CONFIRM OPERATION ?(Y/N): ");
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER A VALID RESPONSE Y OR N !");
                System.out.println("CONFIRM DELETION ?(Y/N): ");
                exceptionThrowed = true;
            }
        }while( (exceptionThrowed) || !(InputChecker.validYesOrNoAnswer(response)) );
        if (response == 'y') //'y': the value has changed | 'n' the value remains the same
            return true;
        return false;
    }

    /**
     * Input the date of the exam, should be valid and in maximum
     * 6 weeks
     * */
    public static LocalDate ExamenDate(){
        System.out.println("EXAMEN DATE:");
        int month, year, day, hour;
        year = SeanceInput.year();
        month = SeanceInput.month(year);
        day = SeanceInput.day(month,year);
        LocalDate localDate = LocalDate.of(year,month,day);
        return localDate;
    }

/*    public static float montantPayeeCode(char category){
        float montantPayee = 0f;
        System.out.println("NOUVEAU MONTANT: ");
        do {
            exceptionThrowed = false;
            try {
                montantPayee = scanner.nextFloat();
                if (!InputChecker.validNewMontantCode('a',montantPayee, condidat)){
                    System.out.println("! PRICE SHOULD BE BETWEEN 0" + "AND" +
                            Prix.prixSeancesCode('a',condidat.getNbSeances()) + "(Prix total des seances code categorie A)");
                    System.out.println("NOUVEAU MONTANT: ");
                    scanner.nextLine();
                }
            }catch (InputMismatchException e){
                System.out.println("! PLEASE ENTER VALID OPTION :) !");
                System.out.println("NOUVEAU MONTANT: ");
                exceptionThrowed = true;
                scanner.nextLine();
            }
        }while ( (exceptionThrowed) || !(InputChecker.validNewMontantCode('a',newMontant, condidat)) );
        scanner.nextLine();
        return montantPayee;
    }*/

}
