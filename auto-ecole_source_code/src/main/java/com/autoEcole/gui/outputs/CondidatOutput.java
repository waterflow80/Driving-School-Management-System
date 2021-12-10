package com.autoEcole.gui.outputs;

import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.services.CondidatService;

import java.util.List;

public class CondidatOutput {

    private static final int WIDTH = 30;

    /**
     * Display the title of the section: CONDIDAT DEPARTMENT
     */
    public static void condidatMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------CONDIDAT DEPARTMENT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UN CONDIDAT");
        System.out.println("2: SUPPRIMER UN CONDIDAT");
        System.out.println("3: AFFIHCER UN CONDIDAT"); //The most important
        System.out.println("4: AFFICHER TOUS LES CONDIDATS");
        System.out.println("5: UPDATE UN CONDIDAT");
        System.out.println("6: MENU PRICIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the title of the section: AJOUTER CONDIDAT
     */
    public static void ajouterCondidatMainMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AJOUTER CONDIDAT------");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: AJOUTER UN CONDIDAT");
        System.out.println("2: GO BACK");
        System.out.println("3: EXIT");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the title of the section: AJOUTER UN CONDIDAT
     */
    public static void headerAjouterCondidat(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AJOUTER UN CONDIDAT------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display Candidate information with all Details
     */
    public static void condidatAllDetails(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("FIRSTNAME: " + condidat.getPrenom());
        System.out.println("LASTNAME: " + condidat.getNom());
        System.out.println("AGE: " + condidat.getAge());
        System.out.println("CIN: " + condidat.getCin());
        System.out.println("PHONE NUMBER: " + condidat.getPhoneNumber());
        System.out.println("CATEGORY: " + condidat.getCategorie());
        System.out.println("N° OF SEANCES: " + condidat.getNbSeances());
        System.out.println("MONTANT PAYEE CODE: " + condidat.getMontantPayeCode() + " DT");
        System.out.println("MONTANT PAYEE CONDUITE: " + condidat.getMontantPayeConduite() + " DT");
        System.out.println("UNPAID AMOUNT OF MONEY: " + CondidatService.montantRestantTotal(condidat,condidat.getCategorie(), condidat.getNbSeances()) + " DT");
        if (condidat.getDateExamen() != null)
            System.out.println("EXAM DATE: " + condidat.getDateExamen().toString());
        else
            System.out.println("EXAM DATE: " + "None");
        System.out.println("EXAM PAYED ?: " + condidat.isExamenPayee());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display Candidate information briefly; firstname, lastname, cin
     */
    public static void condidatFewDetails(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("FIRSTNAME: " + condidat.getPrenom());
        System.out.println("LASTNAME: " + condidat.getNom());
        System.out.println("CIN: " + condidat.getCin());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display List of Condidats information with all Details
     */
    public static void condidatsAllDetails(List<Condidat> condidats){
        System.out.println("-- DISPLAYING ALL CONDIDATS --");
        for (Condidat c:condidats){
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("FIRSTNAME: " + c.getPrenom());
            System.out.println("LASTNAME: " + c.getNom());
            System.out.println("AGE: " + c.getAge());
            System.out.println("CIN: " + c.getCin());
            System.out.println("PHONE NUMBER: " + c.getPhoneNumber());
            System.out.println("CATEGORY: " + c.getCategorie());
            System.out.println("N° OF SEANCES: " + c.getNbSeances());
            System.out.println("MONTANT PAYEE CODE: " + c.getMontantPayeCode() + "DT");
                System.out.println("MONTANT PAYEE CONDUITE: " + c.getMontantPayeConduite() + "DT");
            System.out.println("UNPAID AMOUNT OF MONEY: " + CondidatService.montantRestantTotal(c,c.getCategorie(),c.getNbSeances()) + " DT");
            if (c.getDateExamen() != null)
                System.out.println("EXAM DATE: " + c.getDateExamen().toString());
            else
                System.out.println("EXAM DATE: " + "None");
            System.out.println("EXAM PAYED ?: " + c.isExamenPayee());
            for (int i=0;i<WIDTH+1;i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }

    /**
     * Display List of Condidats information briefly; firstname, lastname, cin
     * Takes list of cin(Strings) as input, and it grabs the associated candidates from the candidate controller
     */
    public static void condidatsFewDetailsByCin(List<String> cinCondidats) {
        for (String cin : cinCondidats) {
            for (int i = 0; i < WIDTH + 1; i++)
                System.out.print("-");
            System.out.print("\n");
            System.out.println("FIRSTNAME: " + CondidatService.getCondidatByCin(cin).getPrenom());
            System.out.println("LASTNAME: " + CondidatService.getCondidatByCin(cin).getNom());
            System.out.println("CIN: " + cin);
            for (int i = 0; i < WIDTH + 1; i++)
                System.out.print("-");
            System.out.print("\n");
        }
    }


    /**
     * Display List of Condidats information briefly; firstname, lastname, cin
     * Takes list of cin(Strings) as input, and it grabs the associated candidates from the candidate controller
     */
    public static void condidatsFewDetails(List<Condidat> condidats) {
        if (!condidats.isEmpty()){
            System.out.println("DISPLAYING ALL CANDIDATES");
            for (Condidat c : condidats) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("FIRSTNAME: " + c.getPrenom());
                System.out.println("LASTNAME: " + c.getNom());
                System.out.println("CIN: " + c.getCin());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO CANDIDATES AT THE MOMENT");
        }

    }

    /**
     * Display the title of the section: SUPPRIMER UN CONDIDAT
     */
    public static void headerSupprimerCondidat(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------SUPPRIMER UN CONDIDAT------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display a message asking for user to enter cin
     * */
    public static void askForCin(){
        System.out.println("CONDIDAT CIN: ");
    }

    /**
     * Displaying a message that the operation was aborted
     * */
    public static void operationAborted(){
        System.out.println("OPERATION ABORTED! ");
    }

    /**
     * Display the title of the section: AFFICHER UN CONDIDAT
     */
    public static void headerAfficherCondidat(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("------AFFICHER UN CONDIDAT------");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the title of the section: AFFICHER TOUS LES CONDIDAT
     */
    public static void headerAfficherTousLesCondidats(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----AFFICHER TOUS LES CONDIDAT----");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the title of the section: UPDATE UN CONDIDAT CONDIDAT
     */
    public static void headerUpdateCondidat(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----UPDATE UN CONDIDAT----");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the menu of attributes to update
     * */
    public static void displayUpdateChoicesMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----UPDATE OPTION-----");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("1: MONTANT PAYEE CODE");
        System.out.println("2: MONTANT PAYEE CONDUITE");
        System.out.println("3: DATE EXAMEN");
        System.out.println("4: EXAMEN PAYEE");
        System.out.println();
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display the paid portion of the candidate's code session
     * */
    public static void displayMontantPayeeCode(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----MONTANT PAYEE CODE----");
        System.out.println("---- " + condidat.getMontantPayeCode());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }


    /**
     * Display the paid portion of the candidate's driving session
     * */
    public static void displayMontantPayeeConduite(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----MONTANT PAYEE CONDUITE----");
        System.out.println("---- " + condidat.getMontantPayeConduite());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display a menu of choices for montant payee (code or conduite)
     * */
    public static void displayMontantPayeeMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
        System.out.println("1: METTRE A NOUVEAU LE MONTANT");
        System.out.println("2: AJOUTER AU MONTANT EXISTANT");
        System.out.println();
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /**
     * Display the state of the examen payee attribute
     * True/ False*/
    public static void displayExamenPayeeState(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----EXAMEN PAYYE ?----");
        System.out.println("---- " + condidat.isExamenPayee());
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Display the current DateExamen if existed
     * */
    public static void displayDateExamenState(Condidat condidat){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("----CURRENT DATE EXAMEN----");
        if (condidat.getDateExamen() != null)
            System.out.println("---- " + condidat.getDateExamen().toString());
        else
            System.out.println("----" + "No Actual Exam Date !");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }

    /**
     * Print a confirmation message when completing an operation
     * */
    public static void operationCompleted(){
        System.out.println("OPERATION COMPLETED! ");
    }

    /**
     * Displays all candidates with their first name, last name and cin number
     * */
    public static void displayAllCondidatsNameCin(List<Condidat> condidats){
        if (!condidats.isEmpty()){
            System.out.println("DISPLAYING ALL CANDIDATES");
            for (Condidat c : condidats) {
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
                System.out.println("FIRSTNAME: " + c.getPrenom());
                System.out.println("LASTNAME: " + c.getNom());
                System.out.println("CIN: " + c.getCin());
                for (int i = 0; i < WIDTH + 1; i++)
                    System.out.print("-");
                System.out.print("\n");
            }
        }else {
            System.out.println("THERE ARE NO CANDIDATES AT THE MOMENT");
        }
    }
}
