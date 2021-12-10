package com.autoEcole.gui.inputs.flotte;

import com.autoEcole.gui.inputs.InputChecker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlotteInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed = true;


    /**
     * Input the choice of the user, 1: Motos, 2: Voiture, 3: Camions, 4: Menu Principale
     * */
    public static String flotteMenuChoice(){
        String choice = "";
        System.out.println("YOUR OPTION IS: ");
        do {
            exceptionThrowed = false;
            try {
                choice = scanner.nextLine();
                if (!InputChecker.validFlotteMenuChoice(choice)){
                    System.out.println("! PLEASE ENTER A VALID CHOICE !");
                    System.out.println("YOUR OPTION IS: ");
                }
            }catch (InputMismatchException e){
                System.out.println("! INVALID INPUT !");
                System.out.println("YOUR OPTION IS: ");
                exceptionThrowed = true;
            }
        }while ( (exceptionThrowed) || !InputChecker.validFlotteMenuChoice(choice));
        return choice;
    }
}
