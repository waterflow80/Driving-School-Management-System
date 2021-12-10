package com.autoEcole.gui.inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed = true;



    /**
     * Input user's choice from the 'Main Menu'
     */
    public static String mainMenu(){

        String choice = "";
        System.out.println("YOUR OPTION IS: ");
        do {
            exceptionThrowed = false;
            try {
                choice = scanner.nextLine();
                if (!InputChecker.validMainMenuChoice(choice)){
                    System.out.println("! PLEASE ENTER A VALID CHOICE !");
                    System.out.println("YOUR OPTION IS: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("YOUR OPTION IS: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validMainMenuChoice(choice));
        return choice;
    }

    /**
     * used as a small time separator when navigating between departments
     * */
    public static String pause(){
        System.out.println("Press Any key to Continue");
        String pause = scanner.nextLine();
        return pause;
    }







}
