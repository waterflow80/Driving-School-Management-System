package com.autoEcole.controllers;

import com.autoEcole.gui.inputs.salaire.SalaireInput;
import com.autoEcole.gui.outputs.salaire.SalaireOutput;
import com.autoEcole.services.salaire.SalaireService;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class SalaireController {

    /**
     * Handling the salaire Menu
     * */
    public static void salaireMenu(){
        String salaireMenuChoice;
        boolean more = true;

        while (more){
            SalaireOutput.salaireMenu();
            salaireMenuChoice = SalaireInput.salaireMenuChoice();
            switch (salaireMenuChoice){
                case "1": //afficher le salaire actuel d'un ingenieur
                    SalaireService.afficherSalaireIngenieur();
                    break;
                case "2": //Menu Principale
                    MainController.mainMenu();
                    break;
            }
        }
    }
}
