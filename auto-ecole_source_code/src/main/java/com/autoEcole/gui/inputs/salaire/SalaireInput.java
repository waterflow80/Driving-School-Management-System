package com.autoEcole.gui.inputs.salaire;

import com.autoEcole.gui.inputs.InputChecker;

import java.util.Scanner;

public class SalaireInput {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean exceptionThrowed;

    /**
     * Input the option of the salaire menu
     * */
    public static String salaireMenuChoice(){
        String choice = "";
        while (!InputChecker.validSalaireMenuChoice(choice)){
            System.out.println("YOUR OPTION IS: ");
            choice = scanner.nextLine();
        }
        return choice;
    }
}
